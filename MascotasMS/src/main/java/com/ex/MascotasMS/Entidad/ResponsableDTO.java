package com.ex.MascotasMS.Entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsableDTO {
    private int idResponsable;
    private String nombre;
    private String turno;
    private String especialidad;
}
