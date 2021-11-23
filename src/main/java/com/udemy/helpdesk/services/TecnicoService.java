package com.udemy.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.helpdesk.domain.Tecnico;
import com.udemy.helpdesk.repositories.TecnicoRepository;
import com.udemy.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class TecnicoService {

	
	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}
}
