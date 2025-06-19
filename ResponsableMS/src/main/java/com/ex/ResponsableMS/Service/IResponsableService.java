package com.ex.ResponsableMS.Service;

import java.util.List;

import com.ex.ResponsableMS.Dominio.Responsable;

public interface IResponsableService {
    public Responsable guardar(Responsable r);
    public List<Responsable> listar();
    public Responsable buscar(int idResponsable);
    public void eliminar(int idResponsable);
}
