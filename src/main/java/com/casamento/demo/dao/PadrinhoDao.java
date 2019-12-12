package com.casamento.demo.dao;

import java.util.List;

import com.casamento.demo.domain.Padrinho;

public interface PadrinhoDao {
	void save(Padrinho padrinho);
	
	void update(Padrinho padrinho);
	
	void delete(Long id);
	
	Padrinho findById(Long id);
	
	List<Padrinho> findAll();
}
