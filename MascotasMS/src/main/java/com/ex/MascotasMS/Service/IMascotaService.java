package com.ex.MascotasMS.Service;

import java.util.List;

import com.ex.MascotasMS.Dominio.Mascota;

public interface IMascotaService {
    Mascota guardar(Mascota m);
    List<Mascota> listar();
    Mascota buscar(int idMascota);
    void eliminar(int idMascota);
}
