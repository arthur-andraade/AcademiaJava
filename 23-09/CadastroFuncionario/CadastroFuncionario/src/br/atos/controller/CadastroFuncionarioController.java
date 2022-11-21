package br.atos.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.atos.models.Coordenador;
import br.atos.models.Gerente;
import br.atos.repository.FuncionarioRepository;
import br.atos.telas.MenuInicial;

public class CadastroFuncionarioController implements ActionListener {

	JTextField nomeTextField;
	JTextField cpfTextField;
	JTextField horasTrabalhadasField;
	JTextField cargoTextField;
	JFrame janelaCadastro;
	FuncionarioRepository repository;

	public CadastroFuncionarioController(JTextField nomeTextField, JTextField cpfTextField,
			JTextField horasTrabalhadasField, JTextField cargoTextField, FuncionarioRepository repository,
			JFrame janelaCadastro) {
		super();
		this.nomeTextField = nomeTextField;
		this.cpfTextField = cpfTextField;
		this.horasTrabalhadasField = horasTrabalhadasField;
		this.cargoTextField = cargoTextField;
		this.repository = repository;
		this.janelaCadastro = janelaCadastro;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (cargoTextField.getText()) {
		case "1":
			Gerente gerente = new Gerente();
			gerente.setNome(nomeTextField.getText());
			gerente.setCpf(cpfTextField.getText());
			gerente.calcularSalarioGerente(Double.valueOf(horasTrabalhadasField.getText()));
			repository.cadastrarFuncionario(gerente);
			break;
		case "2":
			Coordenador coordenador = new Coordenador();
			coordenador.setNome(nomeTextField.getText());
			coordenador.setCpf(cpfTextField.getText());
			coordenador.calcularSalarioGerente(Double.valueOf(horasTrabalhadasField.getText()));
			repository.cadastrarFuncionario(coordenador);
			break;
		default:
			break;
		}

		new MenuInicial(repository).iniciarMenuInicial();
		janelaCadastro.setVisible(false);
		
	}

}
