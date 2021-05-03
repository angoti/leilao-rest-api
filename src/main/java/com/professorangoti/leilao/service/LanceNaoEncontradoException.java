package com.professorangoti.leilao.service;

public class LanceNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public LanceNaoEncontradoException(Integer id) {
		super("Item não encontrado: " + id);
	}

}
