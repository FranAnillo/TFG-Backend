package org.springframework.samples.petclinic.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.envers.NotAudited;
import org.springframework.samples.petclinic.user.User;

@Entity(name= "usuarios")
public class Usuario extends BaseEntity{

	@Column(name = "nombre")
	protected String nombre;
	
	@Column(name = "apellidos")
	protected String apellidos;
	
	@Column(name= "email")
	@Pattern(regexp = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b")
	protected String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@NotAudited
    @JoinColumn(name = "username", referencedColumnName = "username")
	private User user;
	
//	@OneToMany
//	protected Equipo equipo;
}
