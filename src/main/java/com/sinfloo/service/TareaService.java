package com.sinfloo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Tarea;
import org.springframework.stereotype.Service;

import com.sinfloo.interfaces.TareaInterface;
import com.sinfloo.modeloDAO.TareaDAO;
@Service
public class TareaService implements TareaInterface {
	
	@Autowired
	TareaDAO dao;
	public List<Map<String, Object>> listar() {
		return dao.listar();
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
