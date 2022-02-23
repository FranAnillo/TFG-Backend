package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.samples.petclinic.user.Authorities;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "tareas")
public class Tarea extends NamedEntity {
	
	@Column(name="nombre")
	protected String nombre;
	
	@Column(name="descripcion")
	protected String descripcion;
	
//	@Column(name="fechaInicio")
//	protected LocalDate fechaInicio;
//	
//	@Column(name="fechaFin")
//	protected LocalDate fechaFin;
//	
//	@Column(name="duracion")
//	protected int duracion;
//	
//	@Column(name="priorizacion")
//	protected int priorizacion;
//	
	
	
}
