package br.atos.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.controller.CadastroFuncionarioController;
import br.atos.repository.FuncionarioRepository;

public class CadastroFuncionario {

	FuncionarioRepository repository;

	public CadastroFuncionario(FuncionarioRepository repository) {
		this.repository = repository;
	}

	public void iniciarCadastroFuncionario() {
		
		String nomeTexto = "Digite o nome do funcionario:";
		String cpfTexto = "Digite o CPF:";
		String horas = "Digite o horas trabalhada:";
		String listaCargo = "[1] Gerente - [2] Coordenador";
		String cargo = "Cargo funcionario:";
		
		JFrame frameTelaRegistro = new JFrame();
		frameTelaRegistro.setSize(200, 400);
		frameTelaRegistro.setTitle("Cadastrar Funcionario");
		frameTelaRegistro.setLocation(300,300);
		
		JPanel painelTelaRegistro = new JPanel();
		
		JLabel nomeTextoLabel = new JLabel(nomeTexto);
		painelTelaRegistro.add(nomeTextoLabel);
		
		JTextField nomeTextField = new JTextField(10);
		painelTelaRegistro.add(nomeTextField);
		
		JLabel cpfTextoLabel = new JLabel(cpfTexto);
		painelTelaRegistro.add(cpfTextoLabel);
		
		JTextField cpfTextField = new JTextField(10);
		painelTelaRegistro.add(cpfTextField);
		
		JLabel horasLabel = new JLabel(horas);
		painelTelaRegistro.add(horasLabel);
		
		JTextField horasTextField = new JTextField(10);
		painelTelaRegistro.add(horasTextField);
		
		JLabel cargosLabel = new JLabel(listaCargo);
		painelTelaRegistro.add(cargosLabel);
		
		JLabel cargoLabel = new JLabel(cargo);
		painelTelaRegistro.add(cargoLabel);
		
		JTextField cargoTextField = new JTextField(10);
		painelTelaRegistro.add(cargoTextField);
				
		JButton botaoCadastrar = new JButton("Registrar");
		
		CadastroFuncionarioController cadastroFuncionarioController = new CadastroFuncionarioController(nomeTextField, cpfTextField, horasTextField, cargoTextField, repository, frameTelaRegistro);
		
		botaoCadastrar.addActionListener(cadastroFuncionarioController);
		
		painelTelaRegistro.add(botaoCadastrar);
		
		frameTelaRegistro.add(painelTelaRegistro);
		
		frameTelaRegistro.setVisible(true);
		
	}
}
