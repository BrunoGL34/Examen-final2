package com.ex.VeterinariaMS.Dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "veterinaria")
//lombok es una biblioteca para generar codigo automaticamente generalmente codigo java repetitivo
@NoArgsConstructor //constructor vacio
@AllArgsConstructor //constructor parametrizado
@ToString // el metodo to string 
@Getter //los geters
@Setter //los seters
public class Veterinaria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVeterinaria;
	
		private String nombre;
		private String direccion;
		private String telefono;
		
		private Integer responsableId;

}
