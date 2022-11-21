package br.atos.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.atos.repository.FuncionarioRepository;
import br.atos.telas.CadastroFuncionario;
import br.atos.telas.ListarFuncionariosTela;

public class MenuInicialController implements ActionListener {

	JTextField opcaoMenuJTextField;
	JFrame menuInicialJanela;
	FuncionarioRepository repository;

	public MenuInicialController(JTextField opcaoMenuJTextField, JFrame menuInicialJanela, FuncionarioRepository repository) {
		super();
		this.opcaoMenuJTextField = opcaoMenuJTextField;
		this.menuInicialJanela = menuInicialJanela;
		this.repository = repository;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (opcaoMenuJTextField.getText()) {
		case "1":
			new CadastroFuncionario(repository).iniciarCadastroFuncionario();
			break;
		case "2":
			new ListarFuncionariosTela(repository).listar();
			break;
		default:
			break;
		}
		
		menuInicialJanela.setVisible(false);
	}

}
