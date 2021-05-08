package com.professorangoti.leilao.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class ItemDeLeilao implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private double valorMinimo;
	private Boolean leilaoAberto;

	@OneToOne
	private Lance lanceVencedor;
	@OneToMany
	private List<Lance> lancesRecebidos = new ArrayList<Lance>();
	
}