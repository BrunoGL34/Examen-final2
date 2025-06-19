package com.ex.MascotasMS.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ex.MascotasMS.Entidad.ResponsableDTO;

@FeignClient(name = "ResponsablesMS")
public interface IResponsableClient {
	
	@GetMapping("/responsables/{id}")
    ResponsableDTO obtenerResponsable(@PathVariable("id") int id);
}
