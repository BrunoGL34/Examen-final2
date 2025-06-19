package com.ex.VeterinariaMS.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ex.VeterinariaMS.DTO.ClienteDTO;
import com.ex.VeterinariaMS.DTO.ResponsableDTO;
import com.ex.VeterinariaMS.Dominio.Veterinaria;
import com.ex.VeterinariaMS.Entidad.Mascota;
import com.ex.VeterinariaMS.FeignClients.IClienteFeign;
import com.ex.VeterinariaMS.FeignClients.IMascotaFeign;
import com.ex.VeterinariaMS.FeignClients.IResponsableFeign;
import com.ex.VeterinariaMS.Service.VeterinariaServiceImp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(path="/veterinaria")
//@CrossOrigin

@Tag(name="VETERINARIA", description = "Microservicio para la gestión de veterinarias")
public class VeterinariaWS {
    
    //URL http://localhost:8022/veterinaria
    
    @Autowired
    private VeterinariaServiceImp service;
    
    @Autowired
    private IClienteFeign clienteClient;

    @Autowired
    private IResponsableFeign responsableClient;

    @Autowired
    private IMascotaFeign mascotaClient;

    
    //listar  ------------------//URL http://localhost:8022/veterinaria/listar
    @GetMapping("listar")
    @Operation(summary = "MUESTRA UNA LISTA DE LAS VETERINARIAS EXISTENTES", description = "Obtiene una lista de todas las veterinarias registradas en la DB")
    public ResponseEntity<?> listar(){
        List<Veterinaria> veterinarias = service.listar();
        return (veterinarias.isEmpty()) ? ResponseEntity.noContent().build() : ResponseEntity.ok(veterinarias); 
    }
    
    //guardar            //URL http://localhost:8022/veterinaria/guardar
    @PostMapping("guardar")
    @Operation(summary = "GUARDA UNA NUEVA VETERINARIA", description = "Registra una nueva veterinaria en la base de datos.")
    public ResponseEntity<?> guardar(@RequestBody Veterinaria v) {
        if (v.getNombre() == null || v.getNombre().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre de la veterinaria es obligatorio.");
        }

        if (v.getDireccion() == null || v.getDireccion().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("La dirección de la veterinaria es obligatoria.");
        }

        if (v.getResponsableId() <= 0) {
            return ResponseEntity.badRequest().body("Debe indicar un ID de responsable válido.");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(v));
    }

    
    //editar              //URL http://localhost:8022/veterinaria/editar
    @PostMapping("editar")
    @Operation(summary = "EDITA UNA VETERINARIA", description = "Modifica la información de una veterinaria existente y la reemplaza en la DB")
    public ResponseEntity<?> editar(@RequestBody Veterinaria v){
        Veterinaria existe = service.buscar(v.getIdVeterinaria());
        return (existe == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(service.guardar(v));    
    }
    
    //buscar             // http://localhost:8022/veterinaria/buscar?idVeterinaria=2
    @PostMapping("buscar")
    public ResponseEntity<?> buscar(@RequestParam int idVeterinaria){
        Veterinaria existe = service.buscar(idVeterinaria);
        return (existe != null) ? ResponseEntity.ok(existe) : ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("{\"mensaje\":\"No existe una veterinaria con el ID: " + idVeterinaria + ".\"}");
    }
    
    //ELIMINAR         //http://localhost:8022/veterinaria/eliminar/
    @DeleteMapping("eliminar/{idVeterinaria}")
    public ResponseEntity<?> eliminar(@PathVariable int idVeterinaria){
        service.eliminar(idVeterinaria);
        return ResponseEntity.noContent().build();
    }

    //buscar por responsable (en lugar de compra)
    @GetMapping("responsable/{responsableId}")
    @Operation(summary = "BUSCA UNA VETERINARIA POR SU RESPONSABLE", description = "Obtiene las veterinarias asociadas a un responsable específico por su ID.")
    @PostMapping("buscar")
    public ResponseEntity<?> porResponsableId(@PathVariable int responsableId){
        List<Veterinaria> veterinarias = service.porResponsable(responsableId);
        return (!veterinarias.isEmpty()) ? ResponseEntity.ok(veterinarias) : ResponseEntity.noContent().build();
    }
    
    @PostMapping("registrar-mascota")
    public ResponseEntity<?> registrarMascota(@RequestBody Mascota dto) {
        // Validaciones locales
        if (dto.getNombre() == null || dto.getNombre().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre de la mascota es obligatorio.");
        }
        if (dto.getEdad() == null || dto.getEdad() <= 0) {
            return ResponseEntity.badRequest().body("La edad debe ser mayor a cero.");
        }

        if (dto.getRaza() == null || dto.getRaza().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("La raza de la mascota es obligatoria.");
        }
        if (dto.getRazonCita() == null || dto.getRazonCita().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Debes indicar una razón de cita.");
        }

        // Validación cruzada - Cliente
        ClienteDTO cliente = clienteClient.obtenerCliente(dto.getClienteId());
        if (cliente == null) {
            return ResponseEntity.badRequest().body("El cliente especificado no existe.");
        }

        // Validación cruzada - Responsable
        ResponsableDTO responsable = responsableClient.obtenerResponsable(dto.getResponsableId());
        if (responsable == null) {
            return ResponseEntity.badRequest().body("El responsable especificado no existe.");
        }

        // Todo está validado, registrar mascota
        return mascotaClient.guardarMascota(dto);
    }


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/responsable/detalle/{responsableId}")
    @Operation(summary = "OBTIENE LAS VETERINARIAS POR SU RESPONSABLE MEDIANTE EL METODO RESTTEMPLATE", description = "Obtiene una lista de veterinarias relacionadas con un responsable específico mediante una petición REST.")
    public ResponseEntity<?> obtenerVeterinariasPorResponsable(@PathVariable int responsableId) {
        String url = "http://localhost:8083/veterinaria/responsable/" + responsableId;
        
        List<?> veterinarias = restTemplate.getForObject(url, List.class);

        return veterinarias != null && !veterinarias.isEmpty() 
               ? ResponseEntity.ok(veterinarias) 
               : ResponseEntity.noContent().build();
    }
}

