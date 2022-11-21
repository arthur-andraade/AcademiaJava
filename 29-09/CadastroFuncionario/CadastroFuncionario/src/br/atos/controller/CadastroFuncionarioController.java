package br.atos.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;
import java.util.stream.Stream;

import javax.swing.JFrame;
import javax.swing.JTextField;

import br.atos.enums.HorasTrabalhadaValidador;
import br.atos.enums.IValidador;
import br.atos.helper.CpfHelper;
import br.atos.models.Coordenador;
import br.atos.models.Endereco;
import br.atos.models.Gerente;
import br.atos.repository.CoordenadorRepository;
import br.atos.repository.CoordenadorRepositorySingleton;
import br.atos.repository.GerenteRepository;
import br.atos.repository.GerenteRepositorySingleton;
import br.atos.telas.MenuInicial;

public class CadastroFuncionarioController extends AbstractController implements ActionListener {

	private JTextField nomeTextField;
	private JTextField cpfTextField;
	private JTextField horasTrabalhadasField;
	private JTextField cargoTextField;
	private JTextField ruaTextField;
	private JTextField numeroCasaTextField;
	private JTextField estadoTextField;
	private JFrame janelaCadastro;
	private final String SALVO_COM_SUCESSO = "Funcionario salvo com sucesso!";
	private final String ERRO_SALVAR = "Erro ao salvar funcionario";

	public CadastroFuncionarioController(JTextField nomeTextField, JTextField cpfTextField,
			JTextField horasTrabalhadasField, JTextField cargoTextField, JTextField ruaTextField,
			JTextField cidadeTextField, JTextField numeroCasaTextField, JFrame janelaCadastro) {
		this.nomeTextField = nomeTextField;
		this.cpfTextField = cpfTextField;
		this.horasTrabalhadasField = horasTrabalhadasField;
		this.cargoTextField = cargoTextField;
		this.janelaCadastro = janelaCadastro;
		this.ruaTextField = ruaTextField;
		this.estadoTextField = cidadeTextField;
		this.numeroCasaTextField = numeroCasaTextField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String nome = nomeTextField.getText();

		Optional<String> mensagemValidacao = CpfHelper.validarCpf(cpfTextField.getText());

		if (mensagemValidacao.isPresent()) {
			mostrarMensagemInformativa(mensagemValidacao.get());
			return;
		}
		
		mensagemValidacao = validarHorasTrabalhadas(horasTrabalhadasField.getText());

		if (mensagemValidacao.isPresent()) {
			mostrarMensagemInformativa(mensagemValidacao.get());
			return;
		}

		String cpf = cpfTextField.getText();
		Double horasTrabalhadas = Double.valueOf(horasTrabalhadasField.getText());

		switch (cargoTextField.getText()) {
		case "1":
			cadastrarGerente(nome, cpf, horasTrabalhadas);
			break;
		case "2":
			cadastrarCoordenador(nome, cpf, horasTrabalhadas);
			break;
		default:
			mostrarMensagemInformativa("Cargo não reconhecido");
			return;
		}

	}

	private void cadastrarGerente(String nome, String cpf, Double horasTrabalhadas) {

		GerenteRepository gerenteRepository = GerenteRepositorySingleton.getInstance();
		Gerente gerente = new Gerente();
		gerente.setNome(nome);
		gerente.setCpf(cpf);
		gerente.calcularSalarioGerente(horasTrabalhadas);
		gerente.setEndereco(getEnderecoDoFuncionaio());

		if (gerenteRepository.salvar(gerente)) {
			mostrarMensagemInformativa(SALVO_COM_SUCESSO);
			voltarMenuInicial();
		} else {
			mostrarMensagemInformativa(ERRO_SALVAR);
		}

	}

	private void cadastrarCoordenador(String nome, String cpf, Double horasTrabalhadas) {

		CoordenadorRepository coordenadorRepository = CoordenadorRepositorySingleton.getInstance();
		Coordenador coordenador = new Coordenador();
		coordenador.setNome(nome);
		coordenador.setCpf(cpf);
		coordenador.calcularSalarioGerente(horasTrabalhadas);
		coordenador.setEndereco(getEnderecoDoFuncionaio());

		if (coordenadorRepository.salvar(coordenador)) {
			mostrarMensagemInformativa(SALVO_COM_SUCESSO);
			voltarMenuInicial();
		} else {
			mostrarMensagemInformativa(ERRO_SALVAR);
		}

	}

	private Endereco getEnderecoDoFuncionaio() {
		String rua = ruaTextField.getText();
		String estado = estadoTextField.getText();
		String numeroCasa = numeroCasaTextField.getText();
		return new Endereco(rua, estado, numeroCasa);
	}

	private void voltarMenuInicial() {
		new MenuInicial().iniciarMenuInicial();
		janelaCadastro.setVisible(false);
	}
	
	
	private Optional<String> validarHorasTrabalhadas(String horas) {
		return Stream.of(HorasTrabalhadaValidador.values())
				.filter(validador -> validador.validar(horas))
				.findFirst()
				.map(IValidador::getMenssagemValidacao);
	}
}
