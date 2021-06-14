package com.professorangoti.leilao.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.professorangoti.leilao.controller.exception.ErradoException;
import com.professorangoti.leilao.service.exception.ParticipanteNaoEncontradoException;

@ControllerAdvice
public class ParticipanteAdvice {

	@ResponseBody
	@ExceptionHandler(ParticipanteNaoEncontradoException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String participanteNaoEncontrado(ParticipanteNaoEncontradoException ex) {
		return ex.getMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String campoVazio(MethodArgumentNotValidException ex) {
		return ex.getLocalizedMessage();
	}
	
	@ResponseBody
	@ExceptionHandler(ErradoException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	String erro(ErradoException ex) {
		return ex.getLocalizedMessage();
	}

}
