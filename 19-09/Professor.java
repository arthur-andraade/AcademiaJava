public class Professor extends Pessoa {
	private String disciplina;
	private double salario;

	public Professor(String cpf, String nome, String disciplina, double salario){
		super(cpf, nome);
		this.disciplina = disciplina;
		this.salario = salario;
	}
	
	public String geDisciplina(){
		return this.disciplina;
	}
	
	public void setDisciplina(String ddisciplina){
		this.disciplina = disciplina;
	}

	public double getSalario(){
		return this.salario;
	}

	public void setSalario(double salario){
		this.salario = salario;
	}
	
}