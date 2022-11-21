package br.atos.enums;

public enum MenuInicialLabels {
	
	MENU_INICIAL_TITULO("MENU INICIAL"),
	CADASTRO_FUNCIONARIO("[1] Cadastro de Funcionario"),
	LISTAR_FUNCIONARIO("[2] Listar Funcionários"),
	ENCERRAR("[3] Encerrar");
	
	
	private final String texto;
	
	MenuInicialLabels(String texto) {
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}
	
}
