package br.atos.models;

public abstract class Funcionario {
    private String nome;
    private Double salarioLiquido;
    private String cpf;
    private Endereco endereco;
    
    public Funcionario() {
    	
    }
    
    public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Funcionario(String nome, Double salarioLiquido, String cpf, Endereco endereco) {
        this.nome = nome;
        this.salarioLiquido = salarioLiquido;
        this.cpf = cpf;
        this.endereco = endereco;
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

    public void calcularSalario(Double porcentagemImposto, Double horasTrabalhada, Double precoHora) {
        Double salarioBruto = horasTrabalhada * precoHora;
        Double salarioLiquido = salarioBruto - (salarioBruto * (porcentagemImposto/100));
        this.salarioLiquido = salarioLiquido;
    }
}