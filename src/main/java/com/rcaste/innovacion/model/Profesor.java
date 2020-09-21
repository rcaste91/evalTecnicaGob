package com.rcaste.innovacion.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "profesores")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Profesor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesor_id")
	private Long idProfesor;
	
	@Column(name = "profesor_nombre")
	private String nombreProfesor;
	
	@Column(name = "profesor_apellido")
	private String apellidoProfesor;
	
	/*
	@OneToOne
    @JoinTable(
            name = "grados",
            joinColumns = @JoinColumn(name = "profesor_id_grado"),
            inverseJoinColumns = @JoinColumn(name = "grado_id"))
            */
	@Column(name="profesor_id_grado")
	private Long gradoProfesor;
	
	@Column(name = "profesor_edad")
	private int edadProfesor;
	
	@Column(name = "profesor_sexo")
	private String sexoProfesor;
	
	@Column(name = "profesor_titulo")
	private String tituloProfesor;
	
	public Profesor() {
		
	}

	public Long getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Long idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getNombreProfesor() {
		return nombreProfesor;
	}

	public void setNombreProfesor(String nombreProfesor) {
		this.nombreProfesor = nombreProfesor;
	}

	public String getApellidoProfesor() {
		return apellidoProfesor;
	}

	public void setApellidoProfesor(String apellidoProfesor) {
		this.apellidoProfesor = apellidoProfesor;
	}

	public Long getGradoProfesor() {
		return gradoProfesor;
	}

	public void setGradoProfesor(Long gradoProfesor) {
		this.gradoProfesor = gradoProfesor;
	}

	public int getEdadProfesor() {
		return edadProfesor;
	}

	public void setEdadProfesor(int edadProfesor) {
		this.edadProfesor = edadProfesor;
	}

	public String getSexoProfesor() {
		return sexoProfesor;
	}

	public void setSexoProfesor(String sexoProfesor) {
		this.sexoProfesor = sexoProfesor;
	}

	public String getTituloProfesor() {
		return tituloProfesor;
	}

	public void setTituloProfesor(String tituloProfesor) {
		this.tituloProfesor = tituloProfesor;
	}
	
	

}
