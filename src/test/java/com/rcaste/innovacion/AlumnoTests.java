package com.rcaste.innovacion;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rcaste.innovacion.model.Alumno;
import com.rcaste.innovacion.model.Grado;
import com.rcaste.innovacion.model.Profesor;
import com.rcaste.innovacion.repositories.AlumnoRepository;
import com.rcaste.innovacion.repositories.ProfesorRepository;

@SpringBootTest
public class AlumnoTests {

	
	@Autowired
    private AlumnoRepository repository;
	
	@Autowired
    private ProfesorRepository repositoryG;

    @PersistenceContext
    private EntityManager entityManager;	

    @Test
    public void testFind() throws Exception {
    	
        List<Alumno> p = repository.getAllAlumno();
        
        assertNotNull(p);
    }
    
    @Test
    @Transactional
    public void testSaveAndDelete() throws Exception {
    	
    	Profesor g = new Profesor();
    	g = repositoryG.findAll().get(0);
    	
    	Alumno a = new Alumno();
    	a.setApellidoAlumno("Borja");
    	a.setNombreAlumno("Lucia");
    	a.setCarnetAlumno("ca071261");
    	a.setEdadAlumno(11);
    	a.setGradoAlumno("segundo");
    	a.setMadreAlumno("Liliana");
    	a.setPadreAlumno("Rafael");
    	a.setNotaFinalAlumno((float) 7.2);
    	a.setProfesorAlumno(g.getIdProfesor());
    	
    	
        a = repository.saveAndFlush(a);

        entityManager.clear();

        Alumno devolverAl = repository.getOne(a.getIdAlumno());
        assertEquals("Lucia", devolverAl.getNombreAlumno());

        //repository.deleteById(devolverAl.getIdAlumno());
    }
    
    @Test
    public void testUpdate() throws Exception {
    	
    	Alumno p = repository.getAllAlumno().get(0);
    	
    	p.setNombreAlumno("Actualizado");
    	
    	p = repository.saveAndFlush(p);

        entityManager.clear();

        Alumno devolverProf = repository.getOne(p.getIdAlumno());
        assertEquals("Actualizado", devolverProf.getNombreAlumno());

    	
    }

    
}
