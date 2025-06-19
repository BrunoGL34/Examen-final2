package com.ex.VeterinariaMS.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsableDTO {
    private Integer idResponsable;
    private String nombre;
    private Long contacto;
    private Integer veterinariaId;
    
}

