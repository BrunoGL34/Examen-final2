package com.ex.MascotasMS.Entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private int idCliente;
    private String nombre;
    private String apellido;
    private String telefono;
}