package com.udemy.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.helpdesk.domain.Chamado;

public interface PessoaRepository extends JpaRepository<Chamado, Integer> {

}
