package com.ex.MascotasMS.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ex.MascotasMS.Entidad.VeterinariaDTO;

@FeignClient(name = "VeterinariaMS", path = "/veterinaria")
public interface IVeterinariaClient {
    
    @GetMapping("/{id}")
    VeterinariaDTO obtenerVeterinaria(@PathVariable("id") int id);
}
