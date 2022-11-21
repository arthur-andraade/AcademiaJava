package br.atos.repository;

import java.util.List;

import br.atos.models.Funcionario;

public interface IRepository<T extends Funcionario> {
	
	public boolean salvar(T entidade);
	
	public List<T> listar();
	
	public boolean editar(T entidade);
	
	public boolean excluir(T entidade);
}
