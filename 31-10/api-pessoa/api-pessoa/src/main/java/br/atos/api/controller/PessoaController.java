package br.atos.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.atos.api.model.Pessoa;
import br.atos.api.service.PessoaService;

@RestController
@RequestMapping("api/pessoa")
public class PessoaController {
	
	private final PessoaService service;

	public PessoaController(PessoaService service) {
		this.service = service;
	}
	
	@PostMapping
	public void salvarPessoa(@RequestBody Pessoa pessoa) {
		service.salvar(pessoa);
	}
	
	@GetMapping
	public List<Pessoa> buscarPessoas() {
		return service.buscarPessoas();
	}
	
	@GetMapping("{id}")
	public Pessoa buscarPessoa(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@DeleteMapping("{id}")
	public void deletar(@PathVariable Long id) {
		service.delete(id);
	}
	
	@PutMapping
	public void atualizarPessoa(@RequestBody Pessoa pessoa) {
		service.salvar(pessoa);
	}
}
