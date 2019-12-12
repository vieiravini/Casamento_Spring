package com.casamento.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casamento.demo.dao.FestaDao;
import com.casamento.demo.domain.Festa;

@Service @Transactional
public class FestaServiceImpl implements FestaService{

	@Autowired
	private FestaDao dao;
	
	@Override
	public void salvar(Festa festa) {
		dao.save(festa);
	}

	@Override
	public void editar(Festa festa) {
		dao.update(festa);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Festa buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Festa> buscarTodos() {
		return dao.findAll();
	}

}
