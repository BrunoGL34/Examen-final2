package com.ex.VeterinariaMS.FeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

import com.ex.VeterinariaMS.Entidad.Mascota;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@FeignClient(name = "MascotasMS") // Este debe coincidir con el nombre en Eureka
public interface IMascotaFeign {

    @PostMapping("mascota/guardar")
    public  ResponseEntity<?> guardarMascota(@RequestBody Mascota dto);
}

