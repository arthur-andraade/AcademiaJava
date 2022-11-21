package br.atos.controller;

import javax.swing.JOptionPane;

public abstract class AbstractController {
	
	public void mostrarMensagemInformativa(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
	
}
