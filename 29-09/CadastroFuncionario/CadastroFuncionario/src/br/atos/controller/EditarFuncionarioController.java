package br.atos.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.atos.helper.CpfHelper;
import br.atos.models.Coordenador;
import br.atos.models.Gerente;
import br.atos.repository.CoordenadorRepository;
import br.atos.repository.CoordenadorRepositorySingleton;
import br.atos.repository.GerenteRepository;
import br.atos.repository.GerenteRepositorySingleton;
import br.atos.telas.MenuInicial;

public class EditarFuncionarioController extends AbstractController implements ActionListener {

	private JTextField cpfTextField;
	private JTextField nomeTextField;
	private JTextField cargoTextField;
	private JFrame janelaEditar;

	public EditarFuncionarioController(JTextField cpfTextField, JTextField nomeTextField, JTextField cargoTextField,
			JFrame janelaEditar) {
		this.cpfTextField = cpfTextField;
		this.nomeTextField = nomeTextField;
		this.janelaEditar = janelaEditar;
		this.cargoTextField = cargoTextField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (cargoTextField.getText()) {
		case "1":
			editarGerente();
			break;
		case "2":
			editarCoordenador();
			break;
		default:
			break;
		}

	}

	private void editarGerente() {
		
		Optional<String> mensagemValidacao = CpfHelper.validarCpf(cpfTextField.getText());

		if (mensagemValidacao.isPresent()) {
			mostrarMensagemInformativa(mensagemValidacao.get());
			return;
		}

		Gerente gerente = new Gerente();
		gerente.setCpf(cpfTextField.getText());
		gerente.setNome(nomeTextField.getText());

		GerenteRepository repository = GerenteRepositorySingleton.getInstance();

		if (repository.editar(gerente)) {
			mostrarMensagemInformativa("Funcionario editado!");
			voltarMenuInicial();
		} else {
			mostrarMensagemInformativa("Erro em cadastrar funcionario");
		}
	}

	private void editarCoordenador() {

		Optional<String> mensagemValidacao = CpfHelper.validarCpf(cpfTextField.getText());

		if (mensagemValidacao.isPresent()) {
			mostrarMensagemInformativa(mensagemValidacao.get());
			return;
		}

		Coordenador coordenador = new Coordenador();
		coordenador.setCpf(cpfTextField.getText());
		coordenador.setNome(nomeTextField.getText());

		CoordenadorRepository repository = CoordenadorRepositorySingleton.getInstance();

		if (repository.editar(coordenador)) {
			mostrarMensagemInformativa("Funcionario editado!");
			voltarMenuInicial();
		} else {
			mostrarMensagemInformativa("Erro em cadastrar funcionario");
		}

	}

	private void voltarMenuInicial() {
		janelaEditar.setVisible(false);
		new MenuInicial().iniciarMenuInicial();
	}

}
