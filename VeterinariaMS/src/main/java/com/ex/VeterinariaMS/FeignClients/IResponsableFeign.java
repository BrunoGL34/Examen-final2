package com.ex.VeterinariaMS.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.ex.VeterinariaMS.DTO.ResponsableDTO;
import com.ex.VeterinariaMS.Dominio.Veterinaria;

@FeignClient(name = "ResponsableMS")
public interface IResponsableFeign {

	@GetMapping("responsable/veterinaria/{responsableId}")
    public List<Veterinaria> buscarVeterinariasPorResponsable(@PathVariable int responsableId);

    @GetMapping("responsable/buscar")
    public ResponsableDTO obtenerResponsable(@RequestParam int idResponsable);
}
