package com.udemy.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.helpdesk.domain.Pessoa;
import com.udemy.helpdesk.domain.Tecnico;
import com.udemy.helpdesk.domain.dtos.TecnicoDTO;
import com.udemy.helpdesk.repositories.PessoaRepository;
import com.udemy.helpdesk.repositories.TecnicoRepository;
import com.udemy.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.udemy.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class TecnicoService {

	
	@Autowired
	private TecnicoRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! Id: " + id));
	}

	public List<Tecnico> All() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		Tecnico newObj = new Tecnico(objDTO);
		return repository.save(newObj);
	}
	
	public Tecnico update(Integer id, @Valid TecnicoDTO objDTO) {
		objDTO.setId(id);
		Tecnico oldObj = findById(id);
		validaPorCpfEEmail(objDTO);
		oldObj = new Tecnico(objDTO);
		return repository.save(oldObj);
	}

	private void validaPorCpfEEmail(TecnicoDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!!!");
		}
		
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent()  && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("EMAIL já cadastrado no sistema!!!");
		}
	}


}
