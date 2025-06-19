package com.ex.MascotasMS.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.MascotasMS.Dominio.Mascota;

public interface IMascotaDao extends JpaRepository<Mascota, Integer> {
    List<Mascota> findByClienteId(int clienteId);
    List<Mascota> findByVeterinariaId(int veterinariaId);
    List<Mascota> findByResponsableId(int responsableId);
}