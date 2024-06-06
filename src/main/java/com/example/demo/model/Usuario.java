package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String usuario;
	private String clave;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private Integer edad;
	private String direccion;
	private Date fechaAlta;
	private Date fechaBaja;

	public Usuario(String usuario, String clave, String nombre, String apellido1, String apellido2, Integer edad,
			String direccion) {
		this.usuario = usuario;
		this.clave = clave;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.edad = edad;
		this.direccion = direccion;
	}

}
