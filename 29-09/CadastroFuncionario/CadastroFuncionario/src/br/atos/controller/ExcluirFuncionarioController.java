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

public class ExcluirFuncionarioController extends AbstractController implements ActionListener  {
	
	private JFrame janelaExclusao; 
	private JTextField cpfTextField;
	
	public ExcluirFuncionarioController(JFrame janelaExclusao, JTextField cpfTextField) {
		this.janelaExclusao = janelaExclusao;
		this.cpfTextField = cpfTextField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Optional<String> mensagemValidacao = CpfHelper.validarCpf(cpfTextField.getText());

		if (mensagemValidacao.isPresent()) {
			mostrarMensagemInformativa(mensagemValidacao.get());
			return;
		}
		
		
		boolean exclusaoRealizada = false;
		
		GerenteRepository gerenteRepository = GerenteRepositorySingleton.getInstance();
		
		CoordenadorRepository coordenadorRepository = CoordenadorRepositorySingleton.getInstance();
		
		Gerente gerente = new Gerente();
		gerente.setCpf(cpfTextField.getText());
		
		exclusaoRealizada = gerenteRepository.excluir(gerente);
		
		if(exclusaoRealizada) {
			mostrarMensagemInformativa("Funcionario excluido com sucesso");
			voltarMenuInicial();
			return;
		}
	
		Coordenador coordenador = new Coordenador();
		coordenador.setCpf(cpfTextField.getText());
		
		exclusaoRealizada = coordenadorRepository.excluir(coordenador);
		
		if(exclusaoRealizada) {
			mostrarMensagemInformativa("Funcionario excluido com sucesso");
			voltarMenuInicial();
		} else {
			mostrarMensagemInformativa("Erro ao excluir funcionario");
		}
		
	}
	
	private void voltarMenuInicial() {
		new MenuInicial().iniciarMenuInicial();
		janelaExclusao.setVisible(false);
	}
}
