package com.casamento.demo.service;

import java.util.List;

import com.casamento.demo.domain.Padrinho;

public interface PadrinhoService {
	
	void salvar(Padrinho padrinho);
	
	void editar(Padrinho parinho);
	
	void excluir(Long id);
	
	Padrinho buscarPorId(Long id);
	
	List<Padrinho> buscarTodos();
	
}
