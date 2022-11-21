package br.atos.models;

public class Endereco {
	private Long id;
	private String estado;
	private String rua;
	private String numeroCasa;
	
	public Endereco() {
		
	}
	
	public Endereco(String rua, String estado, String numeroCasa) {
		this.rua = rua;
		this.estado = estado;
		this.numeroCasa = numeroCasa;
	}
	
	public String getNumeroCasa() {
		return numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public String getRua() {
		return rua;
	}
	
	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String cidade) {
		this.estado = cidade;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
