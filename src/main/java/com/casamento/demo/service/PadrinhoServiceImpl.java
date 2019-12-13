package com.casamento.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casamento.demo.dao.PadrinhoDao;
import com.casamento.demo.domain.Padrinho;

@Service @Transactional
public class PadrinhoServiceImpl implements PadrinhoService {

	@Autowired
	private PadrinhoDao dao;
	
	
	@Override
	public void salvar(Padrinho padrinho) {
		dao.save(padrinho);
	}

	@Override
	public void editar(Padrinho padrinho) {
		dao.update(padrinho);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Padrinho buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Padrinho> buscarTodos() {
		return dao.findAll();
	}


}
