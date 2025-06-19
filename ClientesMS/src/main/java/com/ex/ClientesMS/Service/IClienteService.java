package com.ex.ClientesMS.Service;

import java.util.List;

import com.ex.ClientesMS.Dominio.Cliente;

public interface IClienteService {
    Cliente guardar(Cliente c);
    List<Cliente> listar();
    Cliente buscar(int idCliente);
    void eliminar(int idCliente);
}
