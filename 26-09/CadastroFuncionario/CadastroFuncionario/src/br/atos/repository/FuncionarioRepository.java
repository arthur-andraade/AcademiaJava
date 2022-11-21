package br.atos.repository;

import java.util.ArrayList;
import java.util.List;

import br.atos.models.Funcionario;

public class FuncionarioRepository implements IFuncionarioRepository {
	
	private List<Funcionario> funcionarios;
	
	public FuncionarioRepository() {
		this.funcionarios = new ArrayList<>();
	}
	
	@Override
	public boolean editar(Funcionario funcionario) {
		
		for(Funcionario func : funcionarios ) {
			
			if(func.getCpf().equals(funcionario.getCpf())) {
				func.setNome(funcionario.getNome());
				return true;
			}
			
		}
		
		return false;	
	}

	@Override
	public boolean salvar(Funcionario funcionario) {
		try {
			this.funcionarios.add(funcionario);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Funcionario> listar() {
		return this.funcionarios;
	}
	
}
