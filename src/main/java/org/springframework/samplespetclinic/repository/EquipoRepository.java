package org.springframework.samplespetclinic.repository;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.model.Equipo;

@org.springframework.stereotype.Repository
public interface EquipoRepository extends Repository<Equipo,Integer>{

	void save(Equipo equipo) throws DataAccessException;
	
	@Query("SELECT equipo From Equipo equipo where id:=id")
	Optional<Equipo> findById(@Param("id") Integer id);
	
}
