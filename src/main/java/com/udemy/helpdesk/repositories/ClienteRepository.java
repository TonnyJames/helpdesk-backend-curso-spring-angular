package com.udemy.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
