package br.atos.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import br.atos.telas.MenuInicial;

public class ListarFuncionarioController implements ActionListener {

	private JFrame janelaListarFuncionario;
	
	public ListarFuncionarioController(JFrame janelaListarFuncionario) {
		this.janelaListarFuncionario = janelaListarFuncionario;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		janelaListarFuncionario.setVisible(false);
		new MenuInicial().iniciarMenuInicial();;
		
	}

}
