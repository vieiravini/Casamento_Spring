package com.casamento.demo.service;

import java.util.List;

import com.casamento.demo.domain.Festa;

public interface FestaService {
	
	void salvar(Festa festa);
	
	void editar(Festa festa);
	
	void excluir(Long id);
	
	Festa buscarPorId(Long id);
	
	List<Festa> buscarTodos();
}
