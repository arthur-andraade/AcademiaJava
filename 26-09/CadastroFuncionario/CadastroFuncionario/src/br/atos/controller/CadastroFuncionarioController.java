package br.atos.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.atos.models.Coordenador;
import br.atos.models.Gerente;
import br.atos.repository.IFuncionarioRepository;
import br.atos.telas.MenuInicial;

public class CadastroFuncionarioController implements ActionListener {

	JTextField nomeTextField;
	JTextField cpfTextField;
	JTextField horasTrabalhadasField;
	JTextField cargoTextField;
	JFrame janelaCadastro;
	IFuncionarioRepository repository;

	public CadastroFuncionarioController(JTextField nomeTextField, JTextField cpfTextField,
			JTextField horasTrabalhadasField, JTextField cargoTextField, IFuncionarioRepository repository,
			JFrame janelaCadastro) {
		this.nomeTextField = nomeTextField;
		this.cpfTextField = cpfTextField;
		this.horasTrabalhadasField = horasTrabalhadasField;
		this.cargoTextField = cargoTextField;
		this.repository = repository;
		this.janelaCadastro = janelaCadastro;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String nome = nomeTextField.getText();
		String cpf = cpfTextField.getText();
		Double horasTrabalhadas = Double.valueOf(horasTrabalhadasField.getText());
		
		switch (cargoTextField.getText()) {
		case "1":
			Gerente gerente = new Gerente();
			gerente.setNome(nome);
			gerente.setCpf(cpf);
			gerente.calcularSalarioGerente(horasTrabalhadas);
			repository.salvar(gerente);
			break;
		case "2":
			Coordenador coordenador = new Coordenador();
			coordenador.setNome(nome);
			coordenador.setCpf(cpf);
			coordenador.calcularSalarioGerente(horasTrabalhadas);
			repository.salvar(coordenador);
			break;
		default:
			break;
		}

		new MenuInicial(repository).iniciarMenuInicial();
		janelaCadastro.setVisible(false);
		
	}

}
