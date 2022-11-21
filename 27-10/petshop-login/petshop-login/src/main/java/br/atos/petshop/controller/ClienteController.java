package br.atos.petshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.atos.petshop.dto.AnimalDTO;
import br.atos.petshop.dto.ClienteDTO;
import br.atos.petshop.model.Animal;
import br.atos.petshop.model.Cliente;
import br.atos.petshop.service.ClienteService;

@Controller
public class ClienteController {
	
	private final ClienteService service;
	
	@Autowired
	public ClienteController(ClienteService service) {
		this.service = service;
	}

	@GetMapping("/cadastroCliente")
	public String cadastroCliente() {
		return "cadastroCliente";
	}
	
	@PostMapping("/cadastroCliente")
	public String cadastrarCliente(ClienteDTO dto) {
		service.salvar(dto.toCliente());
		return "index";
	}
	
	@GetMapping("/cadastroAnimal")
	public ModelAndView cadastrarAnimal() {
		ModelAndView cadastroAnimalView = new ModelAndView("cadastroAnimal");
		cadastroAnimalView.addObject("donos", service.getClientes());
		
		return cadastroAnimalView;
	}
	
	@PostMapping("/cadastroAnimal")
	public String cadastrarAnimal(AnimalDTO dto) {
		service.salvarAnimal(dto);
		return "index";
	}
	
	@GetMapping("/listarClientes")
	public ModelAndView listarClientes() {
		ModelAndView view = new ModelAndView("listarClientes");
		List<Cliente> clientes = service.getClientes();
		view.addObject("clientes", clientes);
		return view;
	}
	
	@GetMapping("/listarAnimais/{idCliente}")
	public ModelAndView listarAnimais(@PathVariable("idCliente") Long id) {
		ModelAndView view = new ModelAndView("listarAnimais");
		List<Animal> animais = service.getById(id).getAnimais();
		view.addObject("animais", animais);
		return view;
	}
}
