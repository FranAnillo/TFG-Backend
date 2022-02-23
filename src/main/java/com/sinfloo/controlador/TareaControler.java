package com.sinfloo.controlador;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinfloo.service.TareaService;

@RestController
@RequestMapping(path="/tareas")
public class TareaControler {

	@Autowired
	TareaService tareaService;
	
	@GetMapping("/listar")
	public List<Map<String,Object>>  listar(){
			return tareaService.listar();

		
	}
}
