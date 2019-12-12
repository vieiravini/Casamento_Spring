package com.casamento.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casamento.demo.dao.PresenteDao;
import com.casamento.demo.domain.Presente;

@Service @Transactional
public class PresenteServiceImpl implements PresenteService {

	@Autowired
	private PresenteDao dao;
	
	@Override
	public void salvar(Presente presente) {
		dao.save(presente);
	}

	@Override
	public void editar(Presente presente) {
		dao.update(presente);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Transactional(readOnly = true)
	@Override
	public Presente buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Presente> buscarTodos() {
		return dao.findAll();
	}

}
