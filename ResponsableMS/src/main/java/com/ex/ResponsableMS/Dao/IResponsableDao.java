package com.ex.ResponsableMS.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.ResponsableMS.Dominio.Responsable;

public interface IResponsableDao extends JpaRepository<Responsable, Integer> {
    
	public List<Responsable> findByVeterinariaId(int veterinariaId);

}
