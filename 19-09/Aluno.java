public class Aluno extends Pessoa {
	private String turma;
	private String advertencia;

	public Aluno(String cpf, String nome, String turma, String advertencia){
		super(cpf, nome);
		this.turma = turma;
		this.advertencia = advertencia;
	}
	
	public String getTurma(){
		return this.turma;
	}
	
	public void setTurma(String turma){
		this.turma = turma;
	}

	public String getAdvertencia(){
		return this.advertencia;
	}

	public void setAdvertencia(String advertencia){
		this.advertencia = advertencia;
	}
	
}