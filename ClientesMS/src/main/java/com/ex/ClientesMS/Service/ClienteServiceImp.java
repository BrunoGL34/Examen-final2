package com.ex.ClientesMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ex.ClientesMS.Dao.IClienteDao;
import com.ex.ClientesMS.Dominio.Cliente;

@Service
public class ClienteServiceImp implements IClienteService {

    @Autowired
    IClienteDao dao;

    @Override
    public Cliente guardar(Cliente c) {
        return dao.save(c);
    }

    @Override
    public List<Cliente> listar() {
        return dao.findAll(Sort.by(Sort.Direction.ASC, "idCliente"));
    }

    @Override
    public Cliente buscar(int idCliente) {
        return dao.findById(idCliente).orElse(null);
    }

    @Override
    public void eliminar(int idCliente) {
        dao.deleteById(idCliente);
    }
}
