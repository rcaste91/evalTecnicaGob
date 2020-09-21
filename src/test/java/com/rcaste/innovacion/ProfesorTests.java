package com.rcaste.innovacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rcaste.innovacion.model.Grado;
import com.rcaste.innovacion.model.Profesor;
import com.rcaste.innovacion.repositories.GradoRepository;
import com.rcaste.innovacion.repositories.ProfesorRepository;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProfesorTests {

	@Autowired
    private ProfesorRepository repository;

    @PersistenceContext
    private EntityManager entityManager;	
    
    @Autowired
    private GradoRepository repositoryG;
	
    @Test
    public void testFind() throws Exception {
    	
        List<Profesor> p = repository.getAllProfesores();
        for (Profesor prof : p) {
        	System.out.println(prof.getNombreProfesor());	
		}
        
        assertNotNull(p);
    }
    
    @Test
    @Transactional
    public void testSaveAndDelete() throws Exception {
    	
    	Grado g = new Grado();
    	g = repositoryG.findAll().get(0);
    	List<Grado> gr = new ArrayList<>();
    	gr.add(g);
    	
    	Profesor p = new Profesor();
    	p.setApellidoProfesor("Castellon");
    	p.setEdadProfesor(32);
    	p.setNombreProfesor("Ronald");
    	p.setSexoProfesor("M");
    	p.setTituloProfesor("prof");
    	p.setGradoProfesor(g.getGradoId());
    	
        p = repository.saveAndFlush(p);

        entityManager.clear();

        Profesor devolverProf = repository.getOne(p.getIdProfesor());
        assertEquals("Ronald", devolverProf.getNombreProfesor());

        repository.deleteById(devolverProf.getIdProfesor());
    }
    
    @Test
    public void testUpdate() throws Exception {
    	
    	Profesor p = repository.getAllProfesores().get(0);
    	
    	p.setNombreProfesor("Actualizado");
    	
    	p = repository.saveAndFlush(p);

        entityManager.clear();

        Profesor devolverProf = repository.getOne(p.getIdProfesor());
        assertEquals("Actualizado", devolverProf.getNombreProfesor());

    	
    }

	
}
