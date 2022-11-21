public class Gerente extends Funcionario{

    private final Double PRECO_HORA = 60.0;
    private final Double PORCENTAGEM_IMPOSTO = 15.0;
    private String regional;
    private Double metaRegional;

    public Gerente(String nome, Double salarioLiquido, String cpf, String regional, Double metaRegional) {
        super(nome, salarioLiquido, cpf);
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
}
