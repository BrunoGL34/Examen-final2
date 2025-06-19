package com.ex.VeterinariaMS.Dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ex.VeterinariaMS.Dominio.Veterinaria;

@Repository
public interface IVeterinariaDao extends JpaRepository<Veterinaria, Integer> {

    // Buscar por nombre
    public List<Veterinaria> findByNombre(String nombre);
    
    public List<Veterinaria> findByResponsableId(int responsableId);


    // Ejemplo de búsqueda personalizada
   // List<Veterinaria> findByDireccionContaining(String direccion);
}

