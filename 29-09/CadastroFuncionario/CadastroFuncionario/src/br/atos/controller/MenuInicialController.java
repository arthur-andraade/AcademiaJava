package br.atos.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.atos.telas.CadastroFuncionarioTela;
import br.atos.telas.EditarFuncionarioTela;
import br.atos.telas.ExcluirFuncionarioTela;
import br.atos.telas.ListarFuncionariosTela;

public class MenuInicialController implements ActionListener {

	private JTextField opcaoMenuJTextField;
	private JFrame menuInicialJanela;

	public MenuInicialController(JTextField opcaoMenuJTextField, JFrame menuInicialJanela) {
		super();
		this.opcaoMenuJTextField = opcaoMenuJTextField;
		this.menuInicialJanela = menuInicialJanela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (opcaoMenuJTextField.getText()) {
		case "1":
			new CadastroFuncionarioTela().iniciarCadastroFuncionario();
			break;
		case "2":
			new ListarFuncionariosTela().listar();
			break;
		case "3":
			new EditarFuncionarioTela().mostrarTelaEditar();
			break;
		case "4":
			new ExcluirFuncionarioTela().mostarTelaExcluir();
			break;
		case "5":
			menuInicialJanela.setVisible(false);
			break;
		}
		
		menuInicialJanela.setVisible(false);
	}

}
