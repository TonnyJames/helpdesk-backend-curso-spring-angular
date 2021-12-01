package com.udemy.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
