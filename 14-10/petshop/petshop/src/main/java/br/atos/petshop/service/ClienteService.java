package br.atos.petshop.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.atos.petshop.dto.AnimalDTO;
import br.atos.petshop.model.Animal;
import br.atos.petshop.model.Cliente;
import br.atos.petshop.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private final ClienteRepository repository;
	
	@Autowired
	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}
	
	public void salvar(Cliente cliente) {
		repository.save(cliente);
	}
	
	public List<Cliente> getClientes() {
		return StreamSupport.stream(repository.findAll().spliterator(), false)
				.collect(Collectors.toList());
	}
	
	public void salvarAnimal(AnimalDTO dto) {
		Cliente cliente = getById(dto.getDono());
		Animal animal = dto.toAnimal();
		animal.setDono(cliente);
		cliente.getAnimais().add(animal);
		this.salvar(cliente);
	}
	
	public Cliente getById(Long idCliente) {
		return repository.findById(idCliente)
				.orElseThrow(()-> new RuntimeException("Cliente não encontrado"));
	}
}
