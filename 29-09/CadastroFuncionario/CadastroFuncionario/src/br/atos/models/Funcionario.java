package br.atos.models;

public class Funcionario {
	private Long id;
	private String nome;
	private Double salarioLiquido;
	private String cpf;
	private Endereco endereco;
	private Long tipoFuncionario;
	
	public Funcionario() {
		
	}
	
	public Funcionario(Long tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	public Funcionario(String nome, Double salarioLiquido, String cpf, Endereco endereco, Long tipoFuncionario) {
		this.nome = nome;
		this.salarioLiquido = salarioLiquido;
		this.cpf = cpf;
		this.endereco = endereco;
		this.setTipoFuncionario(tipoFuncionario);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getSalarioLiquido() {
		return salarioLiquido;
	}

	public void setSalarioLiquido(Double salarioLiquido) {
		this.salarioLiquido = salarioLiquido;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public void calcularSalario(Double porcentagemImposto, Double horasTrabalhada, Double precoHora) {
		Double salarioBruto = horasTrabalhada * precoHora;
		Double salarioLiquido = salarioBruto - (salarioBruto * (porcentagemImposto / 100));
		this.salarioLiquido = salarioLiquido;
	}

	public Long getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(Long tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}
}
