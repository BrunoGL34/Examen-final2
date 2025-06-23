package com.ex.MascotasMS.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ex.MascotasMS.Entidad.ResponsableDTO;

@FeignClient(name = "RESPONSABLEMS", path = "/responsable")
public interface IResponsableClient {

    @GetMapping("/{idResponsable}")
    ResponsableDTO obtenerResponsable(@PathVariable("idResponsable") int id);
}

