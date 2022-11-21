package br.atos.telas;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTable;

import br.atos.models.Funcionario;
import br.atos.repository.FuncionarioRepository;

public class ListarFuncionariosTela {
	
	FuncionarioRepository repository;
	
	public ListarFuncionariosTela(FuncionarioRepository repository) {
		this.repository = repository;
	}
	
	public void listar() {
		
		List<Funcionario> funcionarios = repository.consultarFuncionario();
		
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
		frameLista.setSize(400, 400);
		frameLista.setTitle("Cadastrar Funcionario");
		frameLista.setLocation(300,300);
		
		JTable tabelaFuncionarios = new JTable(tabelaString, colunasTitulos);

		frameLista.add(tabelaFuncionarios);
		frameLista.setVisible(true);
	}
	
}
