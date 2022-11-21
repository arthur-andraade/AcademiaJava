package br.atos.telas;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.atos.controller.ListarFuncionarioController;
import br.atos.models.Funcionario;
import br.atos.repository.IFuncionarioRepository;

public class ListarFuncionariosTela {
	
	IFuncionarioRepository repository;
	
	public ListarFuncionariosTela(IFuncionarioRepository repository) {
		this.repository = repository;
	}
	
	public void listar() {
		
		List<Funcionario> funcionarios = repository.listar();
		
		int quantidadeDeLinhas = funcionarios.size();
		
		String [][] tabelaString = new String [quantidadeDeLinhas][3];
		
		int posicaoLinha = 0;
		int posicaoColuna = 0;
		
		for(Funcionario funcionario : funcionarios) {
			
			tabelaString [posicaoLinha][posicaoColuna] = funcionario.getNome();
			posicaoColuna++;
			
			tabelaString [posicaoLinha][posicaoColuna] = funcionario.getCpf();
			posicaoColuna++;
			
			
			tabelaString [posicaoLinha][posicaoColuna] = String.valueOf(funcionario.getSalarioLiquido());
			posicaoColuna = 0;
			posicaoLinha++;
		
		}
		
		String colunasTitulos[] = {"Nome", "Cpf", "Salario"};
		
		JFrame frameLista = new JFrame();
		frameLista.setSize(600, 600);
		frameLista.setTitle("Cadastrar Funcionario");
		frameLista.setLocation(300,300);
		
		JTable tabelaFuncionarios = new JTable(tabelaString, colunasTitulos);
		tabelaFuncionarios.setBounds(30,40,200,300);
		
		JScrollPane scrollPaneTabela = new JScrollPane(tabelaFuncionarios);
		JPanel panelListarProgramador = new JPanel();
		
		ListarFuncionarioController controller = new ListarFuncionarioController(frameLista, repository);
		
		JButton botaoVoltarMenuInicial = new JButton("Menu Inicial");
		botaoVoltarMenuInicial.addActionListener(controller);
		
		panelListarProgramador.add(botaoVoltarMenuInicial);
		panelListarProgramador.add(scrollPaneTabela);
		
		frameLista.add(panelListarProgramador);
		frameLista.setVisible(true);
	}
	
}
