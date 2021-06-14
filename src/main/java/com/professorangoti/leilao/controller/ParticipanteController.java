package com.professorangoti.leilao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.professorangoti.leilao.controller.exception.ErradoException;
import com.professorangoti.leilao.domain.Participante;
import com.professorangoti.leilao.service.ParticipanteService;

@RestController
@RequestMapping("/participante")
public class ParticipanteController {

	@Autowired
	private ParticipanteService service;

	@GetMapping("/{id}")
	public Participante participante(@PathVariable Integer id) {
		return service.findById(id);
	}

	@GetMapping
	public List<Participante> participantes() {
		//return new ResponseEntity<List<Participante>>(service.todos(),HttpStatus.OK);
		return service.todos();
	}

	@PostMapping
	public Participante novo(@RequestBody @Valid Participante entity) {
		return service.save(entity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

	@PutMapping("/{id}")
	public Participante atualiza(@PathVariable Integer id, @RequestBody Participante entity) {
		return service.atualiza(id, entity);
	}
	
	@GetMapping("/errado")
	public void errado() {
		throw new ErradoException("teste de mensagem");
	}
}
