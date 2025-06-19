package com.ex.MascotasMS.Dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "MASCOTAS")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Mascota {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_mascota")
    @SequenceGenerator(name = "seq_mascota", sequenceName = "SEQ_MASCOTAS", allocationSize = 1)
	@Column(name = "ID_MASCOTA")
	private int idMascota;
	@Column(name = "NOMBRE")
    private String nombre;
	@Column(name = "RAZA")
    private String raza;
	@Column(name = "EDAD")
    private int edad;
	@Column(name = "RAZON_CITA")
    private String razonCita;
	@Column(name = "CLIENTE_ID")
    private int clienteId;
	@Column(name = "RESPONSABLE_ID")
	private int responsableId;
	@Column(name = "VETERINARIA_ID")
	private int veterinariaId;

}
