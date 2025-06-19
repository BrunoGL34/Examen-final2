package com.ex.ClientesMS.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ex.ClientesMS.Dominio.Cliente;

public interface IClienteDao extends JpaRepository<Cliente, Integer> {
}
