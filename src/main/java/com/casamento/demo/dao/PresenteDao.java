package com.casamento.demo.dao;

import java.util.List;

import com.casamento.demo.domain.Presente;

public interface PresenteDao {
	void save(Presente presente);
	
	void update(Presente presente);
	
	void delete(Long id);
	
	Presente findById(Long id);
	
	List<Presente> findAll();
}
