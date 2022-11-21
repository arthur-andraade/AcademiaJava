package br.atos.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.controller.ExcluirFuncionarioController;

public class ExcluirFuncionarioTela {
	
	public ExcluirFuncionarioTela() {
		
	}
	
	public void mostarTelaExcluir() {
		
		JFrame frameExcluir = new JFrame();
		frameExcluir.setLocation(300, 300);
		frameExcluir.setSize(200, 400);
		
		String cpfFuncionario = "CPF do Funcionario:";
		
		JPanel painelExcluir = new JPanel();
		
		JLabel cpfTextoLabel = new JLabel(cpfFuncionario);
		painelExcluir.add(cpfTextoLabel);
		
		JTextField cpfTextField = new JTextField(10);
		painelExcluir.add(cpfTextField);
		
		painelExcluir.add(cpfTextoLabel);
		painelExcluir.add(cpfTextField);
		
		JButton botaoExcluir = new JButton("Excluir");
		
		ExcluirFuncionarioController controlador = new ExcluirFuncionarioController(frameExcluir, cpfTextField);
		
		botaoExcluir.addActionListener(controlador);
		
		painelExcluir.add(botaoExcluir);
		
		frameExcluir.add(painelExcluir);
		frameExcluir.setVisible(true);
	}
}
