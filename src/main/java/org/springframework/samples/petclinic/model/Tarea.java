package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.samples.petclinic.user.Authorities;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "tareas")
public class Tarea extends BaseEntity {
	
	@Column(name="nombre")
	protected String nombre;
	
	@Column(name="descripcion")
	protected String descripcion;
	
	@Column(name="fecha_inicio")
	protected LocalDate fechaInicio;
	
	@Column(name="fecha_fin")
	protected LocalDate fechaFin;
	
	@Column(name="duracion")
	protected int duracion;
	
	@Column(name="priorizacion")
	protected int priorizacion;
	
	@ManyToOne
	protected Usuario usuario;
	
	@ManyToOne
	protected Usuario creator;
	
	@ManyToOne
	protected Equipo equipo;
}
