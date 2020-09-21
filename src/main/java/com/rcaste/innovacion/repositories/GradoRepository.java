package com.rcaste.innovacion.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.rcaste.innovacion.model.Grado;

public interface GradoRepository extends JpaRepository<Grado, Long> {
	
	@Query(
			"select g from Grado g"
			)
	List<Grado> getAllGrados();

}
