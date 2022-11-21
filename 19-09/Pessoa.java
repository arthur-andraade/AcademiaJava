public class Pessoa {
	private String cpf;
	private String nome;
	
	public Pessoa(String cpf, String nome){
		this.cpf = cpf;
		this.nome = nome;
	}
	
	public String getCpf(){
		return this.cpf;
	}
	
	public void setCpf(String cpf){
		this.cpf = cpf;
	}

	public String getNome(){
		return this.nome;
	}

	public void setNome(String nome){
		this.nome = nome;
	}

}