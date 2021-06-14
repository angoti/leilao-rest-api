package com.professorangoti.leilao.service.exception;

public class ParticipanteNaoEncontradoException extends RuntimeException {
	public ParticipanteNaoEncontradoException(Integer id) {
		super("Particioante não encontrado. ID = " + id);
	}
}
