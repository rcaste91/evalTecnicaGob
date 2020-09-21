package com.rcaste.innovacion.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "alumnos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Alumno {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alumno_id")
	private Long idAlumno;
	
	@Column(name = "alumno_nombre")
	private String nombreAlumno;
	
	@Column(name = "alumno_apellido")
	private String apellidoAlumno;
	
	@Column(name = "alumno_numero_de_carnet")
	private String carnetAlumno;
	
	@Column(name = "alumno_grado")
	private String gradoAlumno;
	
	@Column(name = "alumno_padre")
	private String padreAlumno;
	
	@Column(name = "alumno_madre")
	private String madreAlumno;
	
	@Column(name = "alumno_edad")
	private int edadAlumno;
	
	@Column(name = "alumno_nota_final")
	private float notaFinalAlumno;
	
	/*
	@ManyToMany
    @JoinTable(
            name = "alumnos",
            joinColumns = @JoinColumn(name = "profesor_id"),
            inverseJoinColumns = @JoinColumn(name = "alumno_id_profesor"))
            */
	@Column(name = "alumno_id_profesor")
	private Long profesorAlumno;
	
	public Alumno() {
		
	}

	public Long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getApellidoAlumno() {
		return apellidoAlumno;
	}

	public void setApellidoAlumno(String apellidoAlumno) {
		this.apellidoAlumno = apellidoAlumno;
	}

	public String getCarnetAlumno() {
		return carnetAlumno;
	}

	public void setCarnetAlumno(String carnetAlumno) {
		this.carnetAlumno = carnetAlumno;
	}

	public String getGradoAlumno() {
		return gradoAlumno;
	}

	public void setGradoAlumno(String gradoAlumno) {
		this.gradoAlumno = gradoAlumno;
	}

	public String getPadreAlumno() {
		return padreAlumno;
	}

	public void setPadreAlumno(String padreAlumno) {
		this.padreAlumno = padreAlumno;
	}

	public String getMadreAlumno() {
		return madreAlumno;
	}

	public void setMadreAlumno(String madreAlumno) {
		this.madreAlumno = madreAlumno;
	}

	public int getEdadAlumno() {
		return edadAlumno;
	}

	public void setEdadAlumno(int edadAlumno) {
		this.edadAlumno = edadAlumno;
	}

	public float getNotaFinalAlumno() {
		return notaFinalAlumno;
	}

	public void setNotaFinalAlumno(float notaFinalAlumno) {
		this.notaFinalAlumno = notaFinalAlumno;
	}

	public Long getProfesorAlumno() {
		return profesorAlumno;
	}

	public void setProfesorAlumno(Long profesorAlumno) {
		this.profesorAlumno = profesorAlumno;
	}
	
	
}
