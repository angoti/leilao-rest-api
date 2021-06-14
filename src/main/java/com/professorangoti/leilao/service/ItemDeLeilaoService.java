package com.professorangoti.leilao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.professorangoti.leilao.domain.ItemDeLeilao;
import com.professorangoti.leilao.domain.Lance;
import com.professorangoti.leilao.repository.ItemDeLeilaoRepository;
import com.professorangoti.leilao.service.exception.LanceNaoEncontradoException;
import com.professorangoti.leilao.service.exception.LeilaoEncerradoException;

@Service
public class ItemDeLeilaoService {

	@Autowired
	private ItemDeLeilaoRepository repository;

	@Autowired
	private LanceService lanceService;

	public ItemDeLeilao findById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new LanceNaoEncontradoException(id));
	}

	public List<ItemDeLeilao> todos() {
		return repository.findAll();
	}

	public ItemDeLeilao save(ItemDeLeilao entity) {
		return repository.save(entity);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public ItemDeLeilao atualiza(Integer id, ItemDeLeilao entity) {
		entity.setId(id);
		return repository.save(entity);
	}

	public ItemDeLeilao registrarLance(Integer id, Lance lance) {
		ItemDeLeilao itemDeLeilao = findById(id);
		if (itemDeLeilao.getLeilaoAberto()) {
			// salva o lance no banco de dados
			lance = lanceService.save(lance);
			// adiciona à lista de lances do item de leilão
			itemDeLeilao.getLancesRecebidos().add(lance);
			if (itemDeLeilao.getLanceVencedor() == null || 
			   (itemDeLeilao.getLanceVencedor() != null && lance.getValor() > itemDeLeilao.getLanceVencedor().getValor())) {
				itemDeLeilao.setLanceVencedor(lance);
			}
			return atualiza(id, itemDeLeilao);
		}
		throw new LeilaoEncerradoException();
	}

	public Lance atualiza(Integer id) {
		ItemDeLeilao itemDeLeilao = findById(id);
		itemDeLeilao.setLeilaoAberto(false);
		repository.save(itemDeLeilao);
		return itemDeLeilao.getLanceVencedor();
	}
}
