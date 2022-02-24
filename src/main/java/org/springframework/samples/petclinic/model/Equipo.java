package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.samples.petclinic.user.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name= "equipo")
public class Equipo extends BaseEntity{

	@Column(name= "nombre")
	protected String nombre;
	
	@OneToOne
	protected Usuario administrador;
	
	@ManyToOne
	protected Usuario asociados;
	
	@ManyToOne
	protected Usuario managers;
}
