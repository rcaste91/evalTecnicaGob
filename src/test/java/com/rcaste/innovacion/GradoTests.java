package com.rcaste.innovacion;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rcaste.innovacion.model.Grado;
import com.rcaste.innovacion.repositories.GradoRepository;

@SpringBootTest
public class GradoTests {

	
	@Autowired
    private GradoRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testFind() throws Exception {
    	
        List<Grado> g = repository.getAllGrados();
        for (Grado grado : g) {
        	System.out.println(grado.getGradoNombre());	
		}
        
        assertNotNull(g);
    }
}
