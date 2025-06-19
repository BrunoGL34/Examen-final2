package com.ex.ResponsableMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ex.ResponsableMS.Dao.IResponsableDao;
import com.ex.ResponsableMS.Dominio.Responsable;

@Service
public class ResponsableServiceImp implements IResponsableService {

    @Autowired
    private IResponsableDao dao;

    @Override
    public Responsable guardar(Responsable r) {
        return dao.save(r);
    }

    @Override
    public List<Responsable> listar() {
        return dao.findAll(Sort.by(Sort.Direction.ASC, "idResponsable"));
    }

    @Override
    public Responsable buscar(int idResponsable) {
        return dao.findById(idResponsable).orElse(null);
    }

    @Override
    public void eliminar(int idResponsable) {
        dao.deleteById(idResponsable);
    }

    public List<Responsable> porVeterinaria(int veterinariaId){
        return dao.findByVeterinariaId(veterinariaId);
    }

    // Enlace a otros servicios vía REST (si fuera necesario en el futuro)
    @Autowired
    RestTemplate restTemplate;
}

