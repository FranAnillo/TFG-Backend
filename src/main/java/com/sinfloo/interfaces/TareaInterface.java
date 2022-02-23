package com.sinfloo.interfaces;

import java.util.List;
import java.util.Map;

import org.springframework.samples.petclinic.model.Tarea;

public interface TareaInterface {

	public List<Map<String, Object>> listar();
	public List<Map<String, Object>> listar(int id);
	public Tarea add(Tarea tarea);
	public Tarea edit(Tarea tarea);
	public void delete();
	
	
}
