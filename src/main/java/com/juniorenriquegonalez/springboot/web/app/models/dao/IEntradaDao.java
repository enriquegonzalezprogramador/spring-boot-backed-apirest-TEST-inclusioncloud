package com.juniorenriquegonalez.springboot.web.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.juniorenriquegonalez.springboot.web.app.models.entitys.Entrada;


public interface IEntradaDao extends CrudRepository<Entrada, Long>{
	

}
