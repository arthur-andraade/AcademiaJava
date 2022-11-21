package br.atos.repository;

import java.util.List;
import java.util.stream.Collectors;

import br.atos.dao.FuncionarioDao;
import br.atos.models.Coordenador;

public class CoordenadorRepository implements IRepository<Coordenador>{
	
	public CoordenadorRepository() {
	}
	
	@Override
	public boolean editar(Coordenador funcionario) {
		try {
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			return funcionarioDao.editar(funcionario);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean salvar(Coordenador funcionario) {
		try {
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			return funcionarioDao.salvar(funcionario); 
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Coordenador> listar() {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		return funcionarioDao.listar(1l).stream()
				.map(Coordenador::fromFuncionario)
				.collect(Collectors.toList());
	}

	@Override
	public boolean excluir(Coordenador coordenadorParaExclusao) {
		try {
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			return funcionarioDao.excluir(coordenadorParaExclusao);
		} catch (Exception e) {
			return false;
		}
	}

}
