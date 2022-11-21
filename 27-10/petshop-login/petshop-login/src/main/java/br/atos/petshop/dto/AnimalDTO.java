package br.atos.petshop.dto;

import br.atos.petshop.model.Animal;

public class AnimalDTO {
	
	private String nome;
	
	private String especie;
	
	private Integer idade;
	
	private String raca;
	
	private Long dono;
	
	public AnimalDTO() {
	}
	
	public AnimalDTO(String nome, String especie, Integer idade, String raca, Long dono) {
		super();
		this.nome = nome;
		this.especie = especie;
		this.idade = idade;
		this.raca = raca;
		this.dono = dono;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Long getDono() {
		return dono;
	}

	public void setDono(Long dono) {
		this.dono = dono;
	}
	
	public Animal toAnimal() {
		return new Animal(this.nome, this.especie, this.idade, this.raca);
	}
	
}
