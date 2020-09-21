package com.rcaste.innovacion.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcaste.innovacion.model.Profesor;

public interface ProfesorRepository extends JpaRepository<Profesor, Long>{

	@Query(
			"select f from Profesor f"
			)
	List<Profesor> getAllProfesores();
	
	
}
