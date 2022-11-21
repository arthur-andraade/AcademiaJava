package br.atos.api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.atos.api.model.Pessoa;
import br.atos.api.repository.PessoaRepository;

@Service
public class PessoaService {
	
	private final PessoaRepository repository;

	public PessoaService(PessoaRepository repository) {
		this.repository = repository;
	}
	
	public void salvar(Pessoa pessoa) {
		repository.save(pessoa);
	}
	
	public List<Pessoa> buscarPessoas() {
		return repository.findAll();
	}
	
	public Pessoa findById(Long id) {
		return repository.findById(id)
				.orElseThrow(()-> new RuntimeException("Pessoa não encontrada"));
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
}
