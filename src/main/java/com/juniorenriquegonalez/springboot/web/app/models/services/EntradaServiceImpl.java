package com.juniorenriquegonalez.springboot.web.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juniorenriquegonalez.springboot.web.app.models.dao.IEntradaDao;
import com.juniorenriquegonalez.springboot.web.app.models.entitys.Entrada;

@Service
public class EntradaServiceImpl implements IEntradaService {

	@Autowired
	private IEntradaDao entradaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Entrada> findAll() {
		// TODO Auto-generated method stub
		
		return (List<Entrada>) entradaDao.findAll();
		
	}

	@Override
	@Transactional
	public Entrada save(Entrada numeros) {
		// TODO Auto-generated method stub
		return entradaDao.save(numeros);
	}



	
}
