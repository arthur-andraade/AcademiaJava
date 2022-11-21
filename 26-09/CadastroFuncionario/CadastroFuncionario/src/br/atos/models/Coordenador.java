package br.atos.models;

public class Coordenador extends Funcionario {

    private final Double PRECO_HORA = 40.0;
    private final Double PORCENTAGEM_IMPOSTO = 7.0;
    private String loja;
    private Double metaLoja;
    
    public Coordenador() {
    	super();
    }
    
    public Coordenador(String nome, Double salarioLiquido, String cpf, String loja, Double metaLoja) {
        super(nome, salarioLiquido, cpf);
        this.loja = loja;
        this.metaLoja = metaLoja;
    }

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public Double getMetaLoja() {
        return metaLoja;
    }

    public void setMetaLoja(Double metaLoja) {
        this.metaLoja = metaLoja;
    }

    public void calcularSalarioGerente(Double horasTrabalhada) {
        super.calcularSalario(PORCENTAGEM_IMPOSTO, horasTrabalhada, PRECO_HORA);
    }
}
