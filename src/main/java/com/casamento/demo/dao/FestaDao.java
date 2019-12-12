package com.casamento.demo.dao;

import java.util.List;

import com.casamento.demo.domain.Festa;

public interface FestaDao {
	void save(Festa festa);
	
	void update(Festa festa);
	
	void delete(Long id);
	
	Festa findById(Long id);
	
	List<Festa> findAll();
}
