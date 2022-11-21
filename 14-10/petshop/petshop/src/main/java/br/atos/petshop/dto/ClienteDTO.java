package br.atos.petshop.dto;

import br.atos.petshop.model.Cliente;
import br.atos.petshop.model.Endereco;

public class ClienteDTO {
	
	private String nome;
	
	private String cpf;
	
	private Integer idade;
	
	private String rua;
	
	private String cidade;
	
	private Integer numero;
	
	private String complemento;
	
	public ClienteDTO() {
	}
	
	public ClienteDTO(String nome, String cpf, Integer idade, String rua, String cidade, Integer numero,
			String complemento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.rua = rua;
		this.cidade = cidade;
		this.numero = numero;
		this.complemento = complemento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	public Cliente toCliente() {
		Cliente cliente = new Cliente();
		cliente.setNome(this.nome);
		cliente.setCpf(this.cpf);
		cliente.setIdade(this.idade);
		cliente.setEndereco(toEndereco());
		return cliente;
	}
	
	private Endereco toEndereco() {
		Endereco endereco = new Endereco();
		endereco.setCidade(this.cidade);
		endereco.setComplemento(this.complemento);
		endereco.setNumero(this.numero);
		endereco.setRua(this.rua);
		
		return endereco;
	}
	
}
