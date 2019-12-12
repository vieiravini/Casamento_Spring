package com.casamento.demo.service;

import java.util.List;

import com.casamento.demo.domain.Presente;

public interface PresenteService {
	
	void salvar(Presente presente);
	
	void editar(Presente presente);
	
	void excluir(Long id);
	
	Presente buscarPorId(Long id);
	
	List<Presente> buscarTodos();
	
}
