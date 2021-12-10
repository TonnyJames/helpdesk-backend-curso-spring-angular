package com.udemy.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.helpdesk.domain.Chamado;
import com.udemy.helpdesk.domain.Cliente;
import com.udemy.helpdesk.domain.Tecnico;
import com.udemy.helpdesk.domain.dtos.ChamadoDTO;
import com.udemy.helpdesk.domain.enums.Prioridade;
import com.udemy.helpdesk.domain.enums.Status;
import com.udemy.helpdesk.repositories.ChamadoRepository;
import com.udemy.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repository;
	@Autowired
	private TecnicoService tecnicoService;
	@Autowired
	private ClienteService clienteService;

	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto não encontrado! ID: " + id));
	}

	public List<Chamado> findAll() {
		return repository.findAll();
	}

	public Chamado create(ChamadoDTO objDTO) {
		return repository.save(newChamado(objDTO));
	}

	private Chamado newChamado(ChamadoDTO obj) {
		Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
		Cliente cliente = clienteService.findById(obj.getCliente());

		Chamado chamado = new Chamado();
		if (obj.getId() != null) {
			chamado.setId(obj.getId());
		}
		chamado.setCliente(cliente);
		chamado.setTecnico(tecnico);
		chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		chamado.setStatus(Status.toEnum(obj.getStatus()));
		chamado.setTitulo(obj.getTitulo());
		chamado.setObservações(obj.getObservações());
		return chamado;
	}
}
