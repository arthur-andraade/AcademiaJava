package br.atos.telas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.atos.controller.EditarFuncionarioController;
import br.atos.repository.IFuncionarioRepository;

public class EditarFuncionarioTela {
	
	IFuncionarioRepository funcionarioRepository;

	public EditarFuncionarioTela(IFuncionarioRepository repository) {
		this.funcionarioRepository = repository;
	}
	
	public void mostrarTelaEditar() {
		
		JFrame frameTelaEditar = new JFrame();
		frameTelaEditar.setLocation(300,300);
		frameTelaEditar.setSize(200, 400);
		
		String nomeTexto = "Digite o nome do funcionario:";
		String cpfTexto = "Digite o CPF:";
		
		JPanel painelTelaEditar = new JPanel();
		
		JLabel cpfTextoLabel = new JLabel(cpfTexto);
		painelTelaEditar.add(cpfTextoLabel);
		
		JTextField cpfTextField = new JTextField(10);
		painelTelaEditar.add(cpfTextField);
		
		JLabel nomeTextoLabel = new JLabel(nomeTexto);
		painelTelaEditar.add(nomeTextoLabel);
		
		JTextField nomeTextField = new JTextField(10);
		painelTelaEditar.add(nomeTextField);
			
		JButton botaoEditar = new JButton("Editar");
		painelTelaEditar.add(botaoEditar);
		
		EditarFuncionarioController controller = new EditarFuncionarioController(funcionarioRepository, cpfTextField, nomeTextField, frameTelaEditar);
		
		botaoEditar.addActionListener(controller);
		
		frameTelaEditar.add(painelTelaEditar);
		frameTelaEditar.setVisible(true);
		
		
	}
	
	
}
