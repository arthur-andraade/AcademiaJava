package br.atos.repository;

import java.util.ArrayList;
import java.util.List;

import br.atos.models.Funcionario;

public class FuncionarioRepository {
	
	private List<Funcionario> funcionarios;
	
	public FuncionarioRepository() {
		this.funcionarios = new ArrayList<>();
	}
	
	public void cadastrarFuncionario(Funcionario funcionario) {
		this.funcionarios.add(funcionario);
		this.funcionarios.forEach((p1) -> {
			System.out.println("Nome: ".concat(p1.getNome()));
		});
	}
	
	public List<Funcionario> consultarFuncionario() {
		return this.funcionarios;
	}
}
