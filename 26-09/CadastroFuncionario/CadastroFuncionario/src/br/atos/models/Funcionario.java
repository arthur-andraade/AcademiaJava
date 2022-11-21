package br.atos.models;

public class Funcionario {
    private String nome;
    private Double salarioLiquido;
    private String cpf;
    
    public Funcionario() {
    	
    }
    
    public Funcionario(String nome, Double salarioLiquido, String cpf) {
        this.nome = nome;
        this.salarioLiquido = salarioLiquido;
        this.cpf = cpf;
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
