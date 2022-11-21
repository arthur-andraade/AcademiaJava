package br.atos.repository;

import java.util.ArrayList;
import java.util.List;

import br.atos.models.Gerente;

public class GerenteRepository implements IRepository<Gerente> {
		
	private List<Gerente> gerentes;
	
	public GerenteRepository() {
		this.gerentes = new ArrayList<>();
	}
	
	@Override
	public boolean editar(Gerente funcionario) {
		
		for(Gerente ge : gerentes ) {
			
			if(ge.getCpf().equals(funcionario.getCpf())) {
				ge.setNome(funcionario.getNome());
				return true;
			}
			
		}
		
		return false;	
	}

	@Override
	public boolean salvar(Gerente funcionario) {
		try {
			this.gerentes.add(funcionario);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Gerente> listar() {
		return this.gerentes;
	}

	@Override
	public boolean excluir(Gerente gerenteParaExclusao) {
		
		int tamanho = gerentes.size();
		
		for (int i = 0; i < tamanho; i++) {
			
			if(gerenteParaExclusao.getCpf().equals(gerentes.get(i).getCpf())) {
				gerentes.remove(i);
				return true;
			}
			
		}
		
		return false;
	}

	
}
