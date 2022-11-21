package br.atos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.atos.models.Endereco;
import br.atos.models.Funcionario;

public class FuncionarioDao extends AbstractDao {

	public boolean salvar(Funcionario entidade) {

		String sqlEndereco = "INSERT INTO ENDERECO(rua, estado, numero) VALUES (?,?,?)";
		String sqlFuncionario = "INSERT INTO FUNCIONARIO(cpf, nome, salario_liquido, endereco_id, tipo_funcionario) VALUES (?,?,?,?,?)";

		boolean retorno = false;

		PreparedStatement statement = null;

		Connection conexao = getConexao();

		try {
			statement = conexao.prepareStatement(sqlEndereco, Statement.RETURN_GENERATED_KEYS);
			statement.setString(1, entidade.getEndereco().getRua());
			statement.setString(2, entidade.getEndereco().getEstado());
			statement.setString(3, entidade.getEndereco().getNumeroCasa());
			statement.execute();

			ResultSet rs = statement.getGeneratedKeys();

			Long idRetorno = 0l;

			if (rs.next()) {
				idRetorno = rs.getLong(1);
			}

			statement.close();

			statement = conexao.prepareStatement(sqlFuncionario);
			statement.setString(1, entidade.getCpf());
			statement.setString(2, entidade.getNome());
			statement.setString(3, entidade.getSalarioLiquido().toString());
			statement.setString(4, idRetorno.toString());
			statement.setString(5, entidade.getTipoFuncionario().toString());
			statement.execute();
			retorno = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conexao.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return retorno;
	}

	public List<Funcionario> listar(Long tipoFuncionario) {

		List<Funcionario> funcionarios = new ArrayList<>();

		String sql = "select * from rh.funcionario f join rh.endereco e on f.endereco_id = e.id where tipo_funcionario = ?";

		PreparedStatement statement = null;

		Connection conexao = getConexao();

		try {

			statement = conexao.prepareStatement(sql);
			statement.setString(1, tipoFuncionario.toString());
			ResultSet resultado = statement.executeQuery();

			while (resultado.next()) {
				Endereco endereco = new Endereco();
				endereco.setRua(resultado.getString("rua"));
				endereco.setNumeroCasa(resultado.getString("numero"));
				endereco.setEstado(resultado.getString("estado"));

				Funcionario funcionario = new Funcionario();
				funcionario.setId(resultado.getLong("id"));
				funcionario.setCpf(resultado.getString("cpf"));
				funcionario.setNome(resultado.getString("nome"));
				funcionario.setSalarioLiquido(resultado.getDouble("salario_liquido"));
				funcionario.setTipoFuncionario(resultado.getLong("tipo_funcionario"));
				funcionario.setEndereco(endereco);

				funcionarios.add(funcionario);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return funcionarios;
	}

	public boolean editar(Funcionario entidade) {
		String sql = "UPDATE FUNCIONARIO SET NOME = ? WHERE CPF = ?";

		PreparedStatement statement = null;

		Connection conexao = getConexao();

		boolean retorno = false;
		try {
			statement = conexao.prepareStatement(sql);
			statement.setString(1, entidade.getNome());
			statement.setString(2, entidade.getCpf());
			statement.execute();
			retorno = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conexao.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return retorno;
	}

	public boolean excluir(Funcionario entidade) {
		String sql = "DELETE FROM funcionario WHERE CPF = ?";

		PreparedStatement statement = null;

		Connection conexao = getConexao();

		boolean retorno = false;
		try {
			statement = conexao.prepareStatement(sql);
			statement.setString(1, entidade.getCpf());
			statement.execute();
			retorno = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				conexao.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return retorno;
	}

}
