package br.atos.repository;

import java.util.ArrayList;
import java.util.List;

import br.atos.models.Coordenador;

public class CoordenadorRepository implements IRepository<Coordenador>{
	
	private List<Coordenador> coordenadores;
	
	public CoordenadorRepository() {
		this.coordenadores = new ArrayList<>();
	}
	
	@Override
	public boolean editar(Coordenador funcionario) {
		
		for(Coordenador ce : coordenadores ) {
			
			if(ce.getCpf().equals(funcionario.getCpf())) {
				ce.setNome(funcionario.getNome());
				return true;
			}
			
		}
		
		return false;	
	}

	@Override
	public boolean salvar(Coordenador funcionario) {
		try {
			this.coordenadores.add(funcionario);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Coordenador> listar() {
		return this.coordenadores;
	}

	@Override
	public boolean excluir(Coordenador coordenadorParaExclusao) {
		int tamanho = coordenadores.size();
		
		for (int i = 0; i < tamanho; i++) {
			
			if(coordenadorParaExclusao.getCpf().equals(coordenadores.get(i).getCpf())) {
				coordenadores.remove(i);
				return true;
			}
			
		}
		return false;
	}

}
