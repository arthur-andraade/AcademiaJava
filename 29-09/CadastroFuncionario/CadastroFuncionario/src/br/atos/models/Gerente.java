package br.atos.models;

public class Gerente extends Funcionario {

	private final Double PRECO_HORA = 60.0;
	private final Double PORCENTAGEM_IMPOSTO = 15.0;
	private String regional;
	private Double metaRegional;

	public Gerente() {
		super(1l);
	}

	public Gerente(String nome, Double salarioLiquido, String cpf, String regional, Double metaRegional,
			Endereco endereco) {
		super(nome, salarioLiquido, cpf, endereco, 2l);
		this.regional = regional;
		this.metaRegional = metaRegional;
	}

	public String getRegional() {
		return regional;
	}

	public void setRegional(String regional) {
		this.regional = regional;
	}

	public Double getMetaRegional() {
		return metaRegional;
	}

	public void setMetaRegional(Double metaRegional) {
		this.metaRegional = metaRegional;
	}

	public void calcularSalarioGerente(Double horasTrabalhada) {
		super.calcularSalario(PORCENTAGEM_IMPOSTO, horasTrabalhada, PRECO_HORA);
	}

	public static Gerente fromFuncionario(final Funcionario funcionario) {
		final Gerente gerente = new Gerente();
		gerente.setCpf(funcionario.getCpf());
		gerente.setNome(funcionario.getNome());
		gerente.setSalarioLiquido(funcionario.getSalarioLiquido());
		gerente.setEndereco(funcionario.getEndereco());    	
    	return gerente;
	}

}
