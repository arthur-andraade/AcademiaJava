package br.atos.telas;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.atos.controller.ListarFuncionarioController;
import br.atos.models.Coordenador;
import br.atos.models.Gerente;
import br.atos.repository.CoordenadorRepository;
import br.atos.repository.CoordenadorRepositorySingleton;
import br.atos.repository.GerenteRepository;
import br.atos.repository.GerenteRepositorySingleton;

public class ListarFuncionariosTela {

	public ListarFuncionariosTela() {

	}

	public void listar() {

		GerenteRepository repositoryGerente = GerenteRepositorySingleton.getInstance();

		CoordenadorRepository repositoryFuncionario = CoordenadorRepositorySingleton.getInstance();

		List<Gerente> gerentes = repositoryGerente.listar();

		List<Coordenador> coordenadores = repositoryFuncionario.listar();

		int quantidadeDeLinhas = gerentes.size() + coordenadores.size();

		String[][] tabelaString = new String[quantidadeDeLinhas][7];

		int posicaoLinha = 0;
		int posicaoColuna = 0;

		for (Gerente funcionario : gerentes) {

			tabelaString[posicaoLinha][posicaoColuna] = funcionario.getNome();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = funcionario.getCpf();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = String.valueOf(funcionario.getSalarioLiquido());
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = "GERENTE";
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = funcionario.getEndereco().getRua();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = funcionario.getEndereco().getEstado();
			posicaoColuna++;
			
			tabelaString[posicaoLinha][posicaoColuna] = funcionario.getEndereco().getNumeroCasa();
			posicaoColuna = 0;

			posicaoLinha++;

		}
		
		for (Coordenador funcionario : coordenadores) {

			tabelaString[posicaoLinha][posicaoColuna] = funcionario.getNome();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = funcionario.getCpf();
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = String.valueOf(funcionario.getSalarioLiquido());
			posicaoColuna++;

			tabelaString[posicaoLinha][posicaoColuna] = "COORDENADOR";
			posicaoColuna++;
			
			tabelaString[posicaoLinha][posicaoColuna] = funcionario.getEndereco().getRua();
			posicaoColuna++;
			
			tabelaString[posicaoLinha][posicaoColuna] = funcionario.getEndereco().getEstado();
			posicaoColuna++;
			
			tabelaString[posicaoLinha][posicaoColuna] = funcionario.getEndereco().getNumeroCasa();
			posicaoColuna = 0;
			
			posicaoLinha++;

		}

		String colunasTitulos[] = { "Nome", "Cpf", "Salario", "Cargo", "Rua", "Estado", "N° casa" };

		JFrame frameLista = new JFrame();
		frameLista.setSize(800, 500);
		frameLista.setTitle("Cadastrar Funcionario");
		frameLista.setLocation(300, 300);

		JTable tabelaFuncionarios = new JTable(tabelaString, colunasTitulos);
		tabelaFuncionarios.setBounds(30, 40, 750, 400);

		JScrollPane scrollPaneTabela = new JScrollPane(tabelaFuncionarios);
		JPanel panelListarProgramador = new JPanel();

		ListarFuncionarioController controller = new ListarFuncionarioController(frameLista);

		JButton botaoVoltarMenuInicial = new JButton("Menu Inicial");
		botaoVoltarMenuInicial.addActionListener(controller);

		panelListarProgramador.add(botaoVoltarMenuInicial);
		panelListarProgramador.add(scrollPaneTabela);

		frameLista.add(panelListarProgramador);
		frameLista.setVisible(true);
	}

}
