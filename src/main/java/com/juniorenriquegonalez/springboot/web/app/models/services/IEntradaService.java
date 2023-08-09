package com.juniorenriquegonalez.springboot.web.app.models.services;

import java.util.List;

import com.juniorenriquegonalez.springboot.web.app.models.entitys.Entrada;


public interface IEntradaService {

	public List<Entrada> findAll();
	
	public Entrada save(Entrada numeros);
}
