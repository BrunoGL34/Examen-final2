package com.ex.ResponsableMS.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.ex.ResponsableMS.Dominio.Responsable;
import com.ex.ResponsableMS.Service.ResponsableServiceImp;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/responsable")

@Tag(name = "RESPONSABLE", description = "Microservicio para gestionar responsables")
public class ResponsableWS {

    @Autowired
    ResponsableServiceImp service;

    @GetMapping("/listar")
    @Operation(summary = "Lista todos los responsables")
    public ResponseEntity<List<Responsable>> listar(){
        List<Responsable> lista = service.listar();
        return ResponseEntity.ok(lista); 
    }


    @PostMapping("/guardar")
    public ResponseEntity<?> guardarResponsable(@RequestBody Responsable responsable) {
        if (responsable.getNombre() == null || responsable.getNombre().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("El nombre del responsable no puede estar vacío. Intenta de nuevo.");
        }

        if (responsable.getContacto() == null || responsable.getContacto() <= 0) {
            return ResponseEntity.badRequest().body("El número de contacto debe ser un valor numérico positivo. Intenta de nuevo.");
        }

        
        if (responsable.getVeterinariaId() != null && responsable.getVeterinariaId() < 0) {
            return ResponseEntity.badRequest().body("El ID de la veterinaria no puede ser negativo.");
        }


        service.guardar(responsable);
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje", "Responsable registrado correctamente.");
        return ResponseEntity.ok(respuesta);


    }



    @PutMapping("/editar")
    @Operation(summary = "Edita un responsable existente")
    public ResponseEntity<?> editar(@RequestBody Responsable r){
        Responsable existe = service.buscar(r.getIdResponsable());
        return (existe == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(service.guardar(r));
    }

    @PostMapping("/buscar")
    public ResponseEntity<?> buscar(@RequestParam int idResponsable){
        Responsable r = service.buscar(idResponsable);
        return (r != null) ? ResponseEntity.ok(r) :
            ResponseEntity.status(HttpStatus.NOT_FOUND)
                          .body("{\"mensaje\":\"No existe un responsable con ID: " + idResponsable + ".\"}");
    }

    @DeleteMapping("/eliminar/{idResponsable}")
    public ResponseEntity<?> eliminar(@PathVariable int idResponsable){
        service.eliminar(idResponsable);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/veterinaria/{veterinariaId}")
    public ResponseEntity<?> porVeterinaria(@PathVariable int veterinariaId){
        List<Responsable> responsables = service.porVeterinaria(veterinariaId);
        return responsables.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(responsables);
    }
    
    @GetMapping("/{idResponsable}")
    public ResponseEntity<?> obtenerPorId(@PathVariable int idResponsable) {
        Responsable responsable = service.buscar(idResponsable);
        return (responsable != null) 
            ? ResponseEntity.ok(responsable)
            : ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("No existe un responsable con ID " + idResponsable);
    }

}
