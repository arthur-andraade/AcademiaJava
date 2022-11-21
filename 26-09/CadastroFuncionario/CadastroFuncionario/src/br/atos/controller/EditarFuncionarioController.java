package br.atos.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.atos.models.Funcionario;
import br.atos.repository.IFuncionarioRepository;
import br.atos.telas.MenuInicial;

public class EditarFuncionarioController implements ActionListener {

	private IFuncionarioRepository funcionarioRepository;
	private JTextField cpfTextField;
	private JTextField nomeTextField;
	private JFrame janelaEditar;

	public EditarFuncionarioController(IFuncionarioRepository funcionarioRepository, JTextField cpfTextField,
			JTextField nomeTextField, JFrame janelaEditar) {
		this.funcionarioRepository = funcionarioRepository;
		this.cpfTextField = cpfTextField;
		this.nomeTextField = nomeTextField;
		this.janelaEditar = janelaEditar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Funcionario funcionarioParaEditar = new Funcionario();
		
		funcionarioParaEditar.setCpf(cpfTextField.getText());
		funcionarioParaEditar.setNome(nomeTextField.getText());
		
		if(funcionarioRepository.editar(funcionarioParaEditar)) {
			System.out.println("Funcionario editado");
		} else {
			System.out.println("Erro em cadastrar funcionario");
		}
		
		janelaEditar.setVisible(false);
		new MenuInicial(funcionarioRepository).iniciarMenuInicial();
		
	}

}
