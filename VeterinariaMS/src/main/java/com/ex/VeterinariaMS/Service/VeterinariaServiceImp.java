package com.ex.VeterinariaMS.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ex.VeterinariaMS.Dao.IVeterinariaDao;
import com.ex.VeterinariaMS.Dominio.Veterinaria;
import com.ex.VeterinariaMS.FeignClients.IResponsableFeign;

@Service
public class VeterinariaServiceImp implements IVeterinariaService{
	
	@Autowired
	private IVeterinariaDao dao;

	@Override
	public Veterinaria guardar(Veterinaria v) {
		// TODO Auto-generated method stub
		return dao.save(v);
	}

	@Override
	public List<Veterinaria> listar() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Sort.Direction.ASC, "idVeterinaria"));
	}

	@Override
	public Veterinaria buscar(int idVeterinaria) {
		// TODO Auto-generated method stub
		return dao.findById(idVeterinaria).orElse(null);
	}

	@Override
	public void eliminar(int idVeterinaria) {
		dao.deleteById(idVeterinaria);
		// TODO Auto-generated method stub
		
	}
	
	public List<Veterinaria> porResponsable(int responsableId) {
	    return dao.findByResponsableId(responsableId);
	}

	
	//--------------------------------------------------------
	@Autowired
    private IResponsableFeign responsableFC;

    public List<Veterinaria> obtenerVeterinariaPorResponsable(int responsableId) {
        return responsableFC.buscarVeterinariasPorResponsable(responsableId);
    }

    // Mostrar veterinaria con sus responsables
    public HashMap<String, Object> relacionVeterinariaConResponsables(int responsableId) {
        HashMap<String, Object> hash = new HashMap<>();
        List<Veterinaria> veterinarias = responsableFC.buscarVeterinariasPorResponsable(responsableId);

        if (!veterinarias.isEmpty()) {
            hash.put("VETERINARIA", veterinarias);
        } else {
            hash.put("mensaje", "No hay veterinarias asociadas a este responsable.");
        }

        return hash;
    }
    /*
    @Autowired
    private RestTemplate restTemplate;

    public HashMap<String, Object> relacionVeterinariaConResponsables(int responsableId) {
        HashMap<String, Object> hash = new HashMap<>();
        String url = "http://localhost:8086/veterinarias/responsable/" + responsableId;

        List<?> veterinarias = restTemplate.getForObject(url, List.class);

        if (veterinarias != null && !veterinarias.isEmpty()) {
            hash.put("VETERINARIA", veterinarias);
        } else {
            hash.put("mensaje", "No hay veterinarias asociadas a este responsable.");
        }

        return hash;
    }
}*/
	
	

}
