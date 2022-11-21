package br.atos.enums;

public interface IValidador<I> {
	
	public boolean validar(I value);
	
	public String getMenssagemValidacao();
}
