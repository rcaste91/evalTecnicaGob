package com.rcaste.innovacion.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rcaste.innovacion.model.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long>{
	
	@Query(
			"select a from Alumno a"
			)
	List<Alumno> getAllAlumno();
	
	@Query(
			value="select max(alumno_id)+1 from alumnos", nativeQuery=true
			)
	Long getNewMaxIdAlumno();
	
	
	@Query(
			value= "select * from alumnos where alumno_numero_de_carnet = :carnet", nativeQuery = true
			)
	List<Alumno> getAlumnoByCarnet(@Param("carnet") String carnet);
	

}
