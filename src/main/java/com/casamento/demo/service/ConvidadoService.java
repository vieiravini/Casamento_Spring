package com.casamento.demo.service;

import java.util.List;

import com.casamento.demo.domain.Convidado;

public interface ConvidadoService {

	void salvar(Convidado convidado);
	
	void editar(Convidado convidado);
	
	void excluir(Long id);
	
	Convidado buscarPorId(Long id);
	
	List<Convidado> buscarTodos();
	
}
