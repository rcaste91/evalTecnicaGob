package com.rcaste.innovacion.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
@Table(name = "grados")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Grado {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grado_id")
	private Long gradoId;
	
	@Column(name = "grado_nombre")
	private String gradoNombre;

	public Grado() {}

	public Long getGradoId() {
		return gradoId;
	}


	public void setGradoId(Long gradoId) {
		this.gradoId = gradoId;
	}


	public String getGradoNombre() {
		return gradoNombre;
	}


	public void setGradoNombre(String gradoNombre) {
		this.gradoNombre = gradoNombre;
	}
	
	

}
