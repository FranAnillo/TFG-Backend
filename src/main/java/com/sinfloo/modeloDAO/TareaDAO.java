package com.sinfloo.modeloDAO;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.samples.petclinic.model.Tarea;
import org.springframework.stereotype.Repository;

import com.sinfloo.interfaces.TareaInterface;

@Repository
public class TareaDAO implements TareaInterface{

	@Autowired
	JdbcTemplate template;
	
	public List<Map<String, Object>> listar() {
		List<Map<String, Object>> lista= template.queryForList("select * from tarea");
		return lista;
	}

	public List<Map<String, Object>> listar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Tarea add(Tarea tarea) {
		// TODO Auto-generated method stub
		return null;
	}

	public Tarea edit(Tarea tarea) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}

}
