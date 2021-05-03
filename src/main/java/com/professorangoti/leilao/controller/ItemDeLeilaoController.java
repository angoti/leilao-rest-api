package com.professorangoti.leilao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.professorangoti.leilao.domain.ItemDeLeilao;
import com.professorangoti.leilao.service.ItemDeLeilaoService;

@RestController
@RequestMapping("/itemdeleilao")
public class ItemDeLeilaoController {

	@Autowired
	private ItemDeLeilaoService service;

	@GetMapping("/{id}")
	public ItemDeLeilao lance(@PathVariable Integer id) {
		return service.findById(id);
	}

	@GetMapping
	public List<ItemDeLeilao> lances() {
		return service.todos();
	}

	@PostMapping
	public ItemDeLeilao novo(@RequestBody ItemDeLeilao entity) {
		return service.save(entity);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

	@PutMapping("/{id}")
	public ItemDeLeilao atualiza(@PathVariable Integer id, @RequestBody ItemDeLeilao entity) {
		return service.atualiza(id, entity);
	}
}
