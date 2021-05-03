package com.professorangoti.leilao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.professorangoti.leilao.domain.Lance;

@Repository
public interface LanceRepository extends JpaRepository<Lance, Integer> {

}
