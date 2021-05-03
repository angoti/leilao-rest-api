package com.professorangoti.leilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.professorangoti.leilao.domain.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Integer> {

}
