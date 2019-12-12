package com.casamento.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casamento.demo.dao.ConvidadoDao;
import com.casamento.demo.domain.Convidado;

@Service @Transactional
public class ConvidadoServiceImpl implements ConvidadoService {

	@Autowired
	private ConvidadoDao dao;
	
	@Override
	public void salvar(Convidado convidado) {
		dao.save(convidado);
	}

	@Override
	public void editar(Convidado convidado) {
		dao.update(convidado);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Convidado buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Convidado> buscarTodos() {
		return dao.findAll();
	}


}
