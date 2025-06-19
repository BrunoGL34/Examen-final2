package com.ex.MascotasMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ex.MascotasMS.Dao.IMascotaDao;
import com.ex.MascotasMS.Dominio.Mascota;

@Service
public class MascotaServiceImp implements IMascotaService {

    @Autowired
    IMascotaDao dao;

    @Override
    public Mascota guardar(Mascota m) {
        return dao.save(m);
    }

    @Override
    public List<Mascota> listar() {
        return dao.findAll(Sort.by(Sort.Direction.ASC, "idMascota"));
    }

    @Override
    public Mascota buscar(int idMascota) {
        return dao.findById(idMascota).orElse(null);
    }

    @Override
    public void eliminar(int idMascota) {
        dao.deleteById(idMascota);
    }

    public List<Mascota> porCliente(int clienteId){
        return dao.findByClienteId(clienteId);
    }

    public List<Mascota> porResponsable(int responsableId){
        return dao.findByResponsableId(responsableId);
    }

    public List<Mascota> porVeterinaria(int veterinariaId){
        return dao.findByVeterinariaId(veterinariaId);
    }
    
    
}
