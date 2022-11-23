package com.professorangoti.leilao.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.professorangoti.leilao.domain.Participante;
import com.professorangoti.leilao.service.ParticipanteService;

@RestController
@RequestMapping("/participante")
public class ParticipanteController {

	@Autowired
	private ParticipanteService service;

	@GetMapping("/{id}")
	public ResponseEntity<Participante> participante(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<Participante>> participantes() {
		return ResponseEntity.status(HttpStatus.OK).body(service.todos());
	}

	@PostMapping
	public ResponseEntity<Participante> novo(@RequestBody @Valid Participante entity) {
		return ResponseEntity.status(HttpStatus.OK).body(service.save(entity));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Participante> atualiza(@PathVariable Integer id, @RequestBody Participante entity) {
		return ResponseEntity.status(HttpStatus.OK).body(service.atualiza(id, entity));
	}
	
}
