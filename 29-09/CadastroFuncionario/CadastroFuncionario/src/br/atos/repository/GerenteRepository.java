package br.atos.repository;

import java.util.List;
import java.util.stream.Collectors;

import br.atos.dao.FuncionarioDao;
import br.atos.models.Gerente;

public class GerenteRepository implements IRepository<Gerente> {

	public GerenteRepository() {
		
	}

	@Override
	public boolean editar(Gerente funcionario) {
		try {
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			return funcionarioDao.editar(funcionario);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean salvar(Gerente funcionario) {
		try {
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			return funcionarioDao.salvar(funcionario);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<Gerente> listar() {
		FuncionarioDao funcionarioDao = new FuncionarioDao();
		return funcionarioDao.listar(2l).stream()
				.map(Gerente::fromFuncionario)
				.collect(Collectors.toList());
	}

	@Override
	public boolean excluir(Gerente gerenteParaExclusao) {
		try {
			FuncionarioDao funcionarioDao = new FuncionarioDao();
			return funcionarioDao.excluir(gerenteParaExclusao);
		} catch (Exception e) {
			return false;
		}
	}

}
