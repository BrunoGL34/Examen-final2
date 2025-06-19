package com.ex.ClientesMS.FeignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ex.ClientesMS.Entidad.MascotaDTO;

@FeignClient(name = "MascotasMS")
public interface IMascotaClient {
	@GetMapping("/mascotas/por-cliente/{clienteId}")
    List<MascotaDTO> obtenerMascotasPorCliente(@PathVariable("clienteId") int clienteId);
}
