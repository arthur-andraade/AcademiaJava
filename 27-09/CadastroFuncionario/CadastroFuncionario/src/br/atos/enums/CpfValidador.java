package br.atos.enums;

public enum CpfValidador implements IValidador<String> {

	CPF_VAZIO("Cpf não pode ser vazio") {
		@Override
		public boolean validar(String value) {
			return value.length() == 0;
		}
	},
	TAMANHO_CPF("Cpf com tamanho inválido") {
		@Override
		public boolean validar(String value) {
			final int TAMANHO_VALIDO = 3;
			return value.length() != TAMANHO_VALIDO;
		}
	};

	private String mensagemValidacao;

	CpfValidador(String mensagemValidacao) {
		this.mensagemValidacao = mensagemValidacao;
	}

	@Override
	public String getMenssagemValidacao() {
		return this.mensagemValidacao;
	}

}
