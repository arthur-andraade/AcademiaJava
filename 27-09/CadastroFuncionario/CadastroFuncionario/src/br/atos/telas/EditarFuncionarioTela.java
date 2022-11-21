package br.atos.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.controller.EditarFuncionarioController;

public class EditarFuncionarioTela {

	public EditarFuncionarioTela() {
	}

	public void mostrarTelaEditar() {

		JFrame frameTelaEditar = new JFrame();
		frameTelaEditar.setLocation(300, 300);
		frameTelaEditar.setSize(200, 400);

		String nomeTexto = "Digite o nome do funcionario:";
		String cpfTexto = "Digite o CPF:";
		String listaCargo = "[1] Gerente - [2] Coordenador";
		String cargo = "Cargo funcionario:";
		
		JPanel painelTelaEditar = new JPanel();

		JLabel cpfTextoLabel = new JLabel(cpfTexto);
		painelTelaEditar.add(cpfTextoLabel);
		
		JTextField cpfTextField = new JTextField(10);
		painelTelaEditar.add(cpfTextField);
		
		JLabel cargosTextoLabel = new JLabel(listaCargo);
		painelTelaEditar.add(cargosTextoLabel);
		
		JLabel cargoTextoLabel = new JLabel(cargo);
		painelTelaEditar.add(cargoTextoLabel);
		
		JTextField cargoTextField = new JTextField(10);
		painelTelaEditar.add(cargoTextField);
		
		JLabel nomeTextoLabel = new JLabel(nomeTexto);
		painelTelaEditar.add(nomeTextoLabel);

		JTextField nomeTextField = new JTextField(10);
		painelTelaEditar.add(nomeTextField);

		JButton botaoEditar = new JButton("Editar");
		painelTelaEditar.add(botaoEditar);

		EditarFuncionarioController controller = new EditarFuncionarioController(cpfTextField, nomeTextField, cargoTextField, frameTelaEditar);

		botaoEditar.addActionListener(controller);

		frameTelaEditar.add(painelTelaEditar);
		frameTelaEditar.setVisible(true);

	}

}
