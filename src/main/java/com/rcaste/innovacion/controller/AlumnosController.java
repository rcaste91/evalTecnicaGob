package com.rcaste.innovacion.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rcaste.innovacion.model.Alumno;
import com.rcaste.innovacion.model.AlumnoForm;
import com.rcaste.innovacion.repositories.AlumnoRepository;
import com.rcaste.innovacion.repositories.ProfesorRepository;

@RestController
public class AlumnosController {

	@Autowired
    private AlumnoRepository repository;
	
	@Autowired
    private ProfesorRepository repositoryG;

    @PersistenceContext
    private EntityManager entityManager;
	
	
	 @RequestMapping(value = "/alumnos", //
	            method = RequestMethod.GET,
	            produces = { MediaType.APPLICATION_JSON_VALUE})
	    @ResponseBody
	    public List<Alumno> getAlumnos() {
	        List<Alumno> lista = repository.getAllAlumno();
	        return lista;
	    }
	 
	 @RequestMapping(value = "/alumnos/{idAlumno}", //
	            method = RequestMethod.GET, //
	            produces = { MediaType.APPLICATION_JSON_VALUE })
	    @ResponseBody
	    public List<Alumno> getAlumnoByCarnet(@PathVariable("idAlumno") String carnet) {
	  
		 
		 List<Alumno> alList = new ArrayList<>();
		 alList=repository.getAlumnoByCarnet(carnet);
		 
		 return alList;
		 
	    }
	 
	 @RequestMapping(value = "/alumnos", //
	            method = RequestMethod.POST, //
	            produces = { MediaType.APPLICATION_JSON_VALUE})
	    @ResponseBody
	    public Alumno addAlumno(@RequestBody AlumnoForm alumnoForm) {
	  
		 System.out.println(alumnoForm.getAlumnoNombre());
		 Alumno a = new Alumno();
		 a.setNombreAlumno(alumnoForm.getAlumnoNombre());
		 a.setApellidoAlumno(alumnoForm.getAlumnoApellido());
		 a.setCarnetAlumno(alumnoForm.getAlumnoCarnet());
		 a.setEdadAlumno(alumnoForm.getAlumnoEdad());
		 a.setMadreAlumno(alumnoForm.getAlumnoMadre());
		 a.setPadreAlumno(alumnoForm.getAlumnoPadre());
		 a.setNotaFinalAlumno(alumnoForm.getAlumnoNota());
		 a.setGradoAlumno(alumnoForm.getAlumnoGrado());
		 a.setProfesorAlumno(Long.parseLong("1"));
		 a.setIdAlumno(repository.getNewMaxIdAlumno());
		 
		 
	        return repository.saveAndFlush(a);
	    }
	 
	 @RequestMapping(value = "/alumnos", //
	            method = RequestMethod.PUT, //
	            produces = { MediaType.APPLICATION_JSON_VALUE})
	    @ResponseBody
	    public Alumno updateAlumno(@RequestBody AlumnoForm alumnoForm) {
	  
		 Alumno a = repository.getOne(alumnoForm.getAlumnoId());
		 a.setNombreAlumno(alumnoForm.getAlumnoNombre());
		 a.setApellidoAlumno(alumnoForm.getAlumnoApellido());
		 a.setCarnetAlumno(alumnoForm.getAlumnoCarnet());
		 a.setEdadAlumno(alumnoForm.getAlumnoEdad());
		 a.setMadreAlumno(alumnoForm.getAlumnoMadre());
		 a.setPadreAlumno(alumnoForm.getAlumnoPadre());
		 a.setNotaFinalAlumno(alumnoForm.getAlumnoNota());
		 a.setGradoAlumno(alumnoForm.getAlumnoGrado());
		 a.setProfesorAlumno(Long.parseLong("1"));
		 
	        return repository.saveAndFlush(a);
	    }
	 
	 @RequestMapping(value = "/alumnos/{idAlumno}", //
	            method = RequestMethod.DELETE, //
	            produces = { MediaType.APPLICATION_JSON_VALUE })
	    @ResponseBody
	    public void deleteAlumno(@PathVariable("idAlumno") Long alId) {
	  
		 
		 repository.deleteById(alId);
		 

		 
	    }
	    
	
}
