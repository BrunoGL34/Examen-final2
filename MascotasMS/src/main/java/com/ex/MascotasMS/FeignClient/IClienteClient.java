package com.ex.MascotasMS.FeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ex.MascotasMS.Entidad.ClienteDTO;

@FeignClient(name = "ClientesMS", path = "/cliente")
public interface IClienteClient {
    
    @GetMapping("/{idCliente}")
    ClienteDTO obtenerCliente(@PathVariable("idCliente") int idCliente);
}