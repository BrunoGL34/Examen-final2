package com.ex.VeterinariaMS.Entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mascota {
    private String nombre;
    private Integer edad;
    private String raza;
    private String razonCita;
    private Integer clienteId;
    private Integer responsableId;
    private Integer veterinariaId;
}
