package com.professorangoti.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.professorangoti.leilao.domain.ItemDeLeilao;
import com.professorangoti.leilao.domain.Lance;
import com.professorangoti.leilao.service.ItemDeLeilaoService;

@RestController
@RequestMapping("/itemdeleilao")
public class ItemDeLeilaoController {

	@Autowired
	private ItemDeLeilaoService service;

	@GetMapping("/{id}")
	public ResponseEntity<ItemDeLeilao> lance(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<ItemDeLeilao>> lances() {
		return ResponseEntity.status(HttpStatus.OK).body(service.todos());
	}

	@PostMapping
	public ResponseEntity<ItemDeLeilao> novo(@RequestBody ItemDeLeilao entity) {
		return ResponseEntity.status(HttpStatus.OK).body(service.save(entity));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ItemDeLeilao> atualiza(@PathVariable Integer id, @RequestBody ItemDeLeilao entity) {
		return ResponseEntity.status(HttpStatus.OK).body(service.atualiza(id, entity));
	}
	
	
	@PostMapping("/{id}")
	public ResponseEntity<ItemDeLeilao> registraLance(@PathVariable Integer id, @RequestBody Lance lance) {
		return ResponseEntity.status(HttpStatus.OK).body(service.registrarLance(id, lance));
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<Lance> encerra(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.atualiza(id));
	}
}
