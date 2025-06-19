package com.ex.MascotasMS.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ex.MascotasMS.Entidad.ClienteDTO;

@FeignClient(name = "ClientesMS")
public interface IClienteClient {
	@GetMapping("/clientes/{id}")
    ClienteDTO obtenerCliente(@PathVariable("id") int id);
}