package com.ex.VeterinariaMS.FeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ex.VeterinariaMS.DTO.ClienteDTO;


@FeignClient(name = "ClientesMS")
public interface IClienteFeign {

	@GetMapping("cliente/buscar")
    ClienteDTO obtenerCliente(@RequestParam int idCliente);
}