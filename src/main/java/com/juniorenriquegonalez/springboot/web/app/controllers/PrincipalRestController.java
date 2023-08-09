package com.juniorenriquegonalez.springboot.web.app.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juniorenriquegonalez.springboot.web.app.models.entitys.Entrada;
import com.juniorenriquegonalez.springboot.web.app.models.services.IEntradaService;
import com.juniorenriquegonalez.springboot.web.app.utils.Metodos;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api")
public class PrincipalRestController {
	
	@Autowired
	private IEntradaService entradaService;
	
	@GetMapping("/valores")
	public List<Entrada> index() {
		
		List<Entrada> entradas = Metodos.caculo_entradas(entradaService.findAll());
		
		return entradas;
	}
	
	
	@PostMapping(value = "/valores", consumes = MediaType.APPLICATION_JSON_VALUE,
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> create( @RequestBody Map<String, Object> valoresData) {
		
		Entrada entrada = new Entrada();
		entrada.setX((int) valoresData.get("x"));
		entrada.setY((int) valoresData.get("y"));
		entrada.setN((int) valoresData.get("n"));
		
		Entrada values = null;
		Map<String, Object> response = new HashMap<>();
		
		try {
			values = entradaService.save(entrada);
			
		}catch(DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
			 return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", " Entrada ha sido creado con exito!");
		List<Entrada> entradas = Collections.singletonList(entrada);
		response.put("Entrada", Metodos.caculo_entradas(entradas));

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
}
