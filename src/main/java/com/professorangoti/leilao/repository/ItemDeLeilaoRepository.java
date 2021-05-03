package com.professorangoti.leilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.professorangoti.leilao.domain.ItemDeLeilao;

@Repository
public interface ItemDeLeilaoRepository extends JpaRepository<ItemDeLeilao, Integer> {

}
