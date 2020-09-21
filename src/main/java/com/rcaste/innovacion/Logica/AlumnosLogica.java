package com.rcaste.innovacion.Logica;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.rcaste.innovacion.repositories.AlumnoRepository;
import com.rcaste.innovacion.repositories.ProfesorRepository;

public class AlumnosLogica {

	@Autowired
    private AlumnoRepository repository;
	
	@Autowired
    private ProfesorRepository repositoryG;

    @PersistenceContext
    private EntityManager entityManager;	

    public AlumnosLogica() {
    	
    }
    
    
}
