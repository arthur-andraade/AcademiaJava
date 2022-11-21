package br.atos.repository;

import java.util.List;

import br.atos.models.Funcionario;

public interface IFuncionarioRepository {
	
	public boolean salvar(Funcionario funcionario);
	
	public List<Funcionario> listar();
	
	public boolean editar(Funcionario funcionario);
}
