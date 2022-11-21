package br.atos.models;

public class Coordenador extends Funcionario {

    private final Double PRECO_HORA = 40.0;
    private final Double PORCENTAGEM_IMPOSTO = 7.0;
    private String loja;
    private Double metaLoja;
    
    public Coordenador() {
    	super(2l);
    }
    
    public Coordenador(String nome, Double salarioLiquido, String cpf, String loja, Double metaLoja, Endereco endereco) {
        super(nome, salarioLiquido, cpf, endereco, 1l);
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
    
    public static Coordenador fromFuncionario(final Funcionario funcionario) {
    	final Coordenador coordenador = new Coordenador();
    	coordenador.setCpf(funcionario.getCpf());
    	coordenador.setNome(funcionario.getNome());
    	coordenador.setSalarioLiquido(funcionario.getSalarioLiquido());
    	coordenador.setEndereco(funcionario.getEndereco());    	
    	return coordenador;
    }
}
