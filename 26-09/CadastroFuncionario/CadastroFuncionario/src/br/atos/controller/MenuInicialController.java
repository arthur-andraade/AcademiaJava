package br.atos.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.atos.repository.IFuncionarioRepository;
import br.atos.telas.CadastroFuncionarioTela;
import br.atos.telas.EditarFuncionarioTela;
import br.atos.telas.ListarFuncionariosTela;

public class MenuInicialController implements ActionListener {

	JTextField opcaoMenuJTextField;
	JFrame menuInicialJanela;
	IFuncionarioRepository repository;

	public MenuInicialController(JTextField opcaoMenuJTextField, JFrame menuInicialJanela, IFuncionarioRepository repository) {
		super();
		this.opcaoMenuJTextField = opcaoMenuJTextField;
		this.menuInicialJanela = menuInicialJanela;
		this.repository = repository;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (opcaoMenuJTextField.getText()) {
		case "1":
			new CadastroFuncionarioTela(repository).iniciarCadastroFuncionario();
			break;
		case "2":
			new ListarFuncionariosTela(repository).listar();
			break;
		case "3":
			new EditarFuncionarioTela(repository).mostrarTelaEditar();
			break;
		case "4":
			menuInicialJanela.setVisible(false);
			break;
		default:
			break;
		}
		
		menuInicialJanela.setVisible(false);
	}

}
