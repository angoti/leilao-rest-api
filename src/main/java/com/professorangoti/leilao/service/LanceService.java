package com.professorangoti.leilao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.professorangoti.leilao.domain.Lance;
import com.professorangoti.leilao.repository.LanceRepository;
import com.professorangoti.leilao.service.exception.LanceNaoEncontradoException;

@Service
public class LanceService {

	@Autowired
	private LanceRepository repository;

	public Lance findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new LanceNaoEncontradoException(id));
	}

	public List<Lance> todos() {
		return repository.findAll();
	}

	public Lance save(Lance entity) {
		return repository.save(entity);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public Lance atualiza(Integer id, Lance entity) {
		entity.setId(id);
		return repository.save(entity);
	}
	

}

