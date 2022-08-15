package com.projetomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetomc.domain.Cliente;
import com.projetomc.repositories.ClienteRepository;
import com.projetomc.services.exceptions.ObejctNotFoundException;


@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;

	public List<Cliente> listaClientes(){
		return repo.findAll();
	}
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObejctNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));		
	}
}
