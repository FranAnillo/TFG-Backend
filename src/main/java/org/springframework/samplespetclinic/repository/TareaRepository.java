package org.springframework.samplespetclinic.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Tarea;

public interface TareaRepository extends Repository<Tarea, Integer>{

	void save (Tarea tarea) throws DataAccessException;
	
	List<Tarea> findTareaById(Integer tareaId);
	
	@Query("SELECT tarea FROM Tareas where id=:tareaId")
	Optional<Tarea> findById(@Param("tareaId") Integer tareaId); 
	
	
}
