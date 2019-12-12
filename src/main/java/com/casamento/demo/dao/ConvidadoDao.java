package com.casamento.demo.dao;

import java.util.List;

import com.casamento.demo.domain.Convidado;

public interface ConvidadoDao {
	
	void save(Convidado convidado);
	
	void update(Convidado convidado);
	
	void delete(Long id);
	
	Convidado findById(Long id);
	
	List<Convidado> findAll();
	
}
