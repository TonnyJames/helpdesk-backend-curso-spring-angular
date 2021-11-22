package com.udemy.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.helpdesk.domain.Pessoa;

public interface ClienteRepository extends JpaRepository<Pessoa, Integer> {

}
