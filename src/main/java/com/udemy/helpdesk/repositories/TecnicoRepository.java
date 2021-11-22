package com.udemy.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
