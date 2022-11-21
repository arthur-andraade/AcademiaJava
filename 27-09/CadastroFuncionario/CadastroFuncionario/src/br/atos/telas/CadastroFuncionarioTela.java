package br.atos.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.controller.CadastroFuncionarioController;

public class CadastroFuncionarioTela {


	public CadastroFuncionarioTela() {
	}

	public void iniciarCadastroFuncionario() {
		
		String nomeTexto = "Digite o nome do funcionario:";
		String cpfTexto = "Digite o CPF:";
		String horas = "Digite o horas trabalhada:";
		String listaCargo = "[1] Gerente - [2] Coordenador";
		String cargo = "Cargo funcionario:";
		String enderecoFuncionario = "Endereço do Funcionario";
		String rua = "Rua:";
		String estado = "Estado:";
		String numeroCasa = "Numero casa:";
		
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
		
		JLabel enderecoFuncionarioLabel = new JLabel(enderecoFuncionario);
		painelTelaRegistro.add(enderecoFuncionarioLabel);
		
		JLabel ruaLabel = new JLabel(rua);
		painelTelaRegistro.add(ruaLabel);
		
		JTextField ruaTextField = new JTextField(10);
		painelTelaRegistro.add(ruaTextField);
		
		JLabel estadoLabel = new JLabel(estado);
		painelTelaRegistro.add(estadoLabel);
		
		JTextField estadoTextField = new JTextField(10);
		painelTelaRegistro.add(estadoTextField);
		
		JLabel numeroCasaLabel = new JLabel(numeroCasa);
		painelTelaRegistro.add(numeroCasaLabel);
		
		JTextField numeroCasaTextField = new JTextField(10);
		painelTelaRegistro.add(numeroCasaTextField);
		
		JButton botaoCadastrar = new JButton("Registrar");
		
		CadastroFuncionarioController cadastroFuncionarioController = new CadastroFuncionarioController(nomeTextField, cpfTextField, horasTextField, cargoTextField, ruaTextField, estadoTextField, numeroCasaTextField, frameTelaRegistro);
		
		botaoCadastrar.addActionListener(cadastroFuncionarioController);
		
		painelTelaRegistro.add(botaoCadastrar);
		
		frameTelaRegistro.add(painelTelaRegistro);
		
		frameTelaRegistro.setVisible(true);
		
	}
}
