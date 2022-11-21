package br.atos.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import br.atos.repository.IFuncionarioRepository;
import br.atos.telas.MenuInicial;

public class ListarFuncionarioController implements ActionListener {

	private JFrame janelaListarFuncionario;
	private IFuncionarioRepository repository;
	
	public ListarFuncionarioController(JFrame janelaListarFuncionario, IFuncionarioRepository repository) {
		this.janelaListarFuncionario = janelaListarFuncionario;
		this.repository = repository;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		janelaListarFuncionario.setVisible(false);
		new MenuInicial(repository).iniciarMenuInicial();;
		
	}

}
