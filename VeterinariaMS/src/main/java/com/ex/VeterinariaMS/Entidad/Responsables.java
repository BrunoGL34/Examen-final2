package com.ex.VeterinariaMS.Entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Responsables {
    private Integer idResponsable;
    private String nombre;
    private Long contacto;
    private Integer veterinariaId;
}
