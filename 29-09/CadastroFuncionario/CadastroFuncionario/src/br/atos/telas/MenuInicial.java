package br.atos.telas;

import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.controller.MenuInicialController;
import br.atos.enums.MenuInicialLabels;

public class MenuInicial {

	public MenuInicial() {
	}

	public void iniciarMenuInicial() {

		JFrame menuInicialJanela = new JFrame();
		menuInicialJanela.setSize(200, 200);
		menuInicialJanela.setLocation(300, 300);

		JPanel panelMenuInicial = new JPanel();

		Stream.of(MenuInicialLabels.values()).forEach((label) -> {
			panelMenuInicial.add(new JLabel(label.getTexto()));
		});

		JTextField opcaoMenuTextField = new JTextField(10);
		panelMenuInicial.add(opcaoMenuTextField);

		JButton botaoMenu = new JButton("OK");
		panelMenuInicial.add(botaoMenu);

		MenuInicialController controlador = new MenuInicialController(opcaoMenuTextField, menuInicialJanela);
		botaoMenu.addActionListener(controlador);

		menuInicialJanela.add(panelMenuInicial);
		menuInicialJanela.setVisible(true);

	}

}
