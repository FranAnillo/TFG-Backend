package org.springframework.samplespetclinic.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Equipo;
import org.springframework.samples.petclinic.model.Tarea;

@org.springframework.stereotype.Repository
public interface TareaRepository extends Repository<Tarea, Integer>{

	void save (Tarea tarea) throws DataAccessException;
	
	List<Tarea> findAll();
	
	@Query("SELECT tarea FROM Tareas where id=:tareaId")
	Optional<Tarea> findById(@Param("tareaId") Integer tareaId); 
	
	@Query("SELECT tarea FROM Tareas where usuario=:null AND tarea.equipo:=eqp")
	List<Tarea> findTareaUnassigned(@Param("eqp") Equipo equipo);
	
	@Query("SELECT tarea FROM Tareas WHERE usuario=:usr AND tarea.equipo:=eqp")
	List<Tarea> findTareasByAssigned(@Param("eqp") Equipo equipo);

	@Query("SELECT tarea FROM Tareas WHERE tarea.equipo:=eqp")
	List<Tarea> allTareasFromTeam(@Param("eqp") Equipo equipo);
}
