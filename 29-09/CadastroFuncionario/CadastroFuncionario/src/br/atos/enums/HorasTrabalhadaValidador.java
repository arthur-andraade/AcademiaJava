package br.atos.enums;

public enum HorasTrabalhadaValidador implements IValidador<String> {
	
	HORAS_VAZIA("Horas trabalha não pode ser branco"){
		@Override
		public boolean validar(String value) {
			return value.isBlank();
		}
	},
	IS_DIGITO("Horas trabalhada precisa ser numerico"){
		@Override
		public boolean validar(String value) {
			char[] caracteres = value.toCharArray();
			
			for (int i = 0; i < caracteres.length; i++) {
				if(!Character.isDigit(caracteres[i])) {
					return true;
				}
			}
			
			return false;
			
		}
	};
	
	private String mensagemValidacao;
	
	HorasTrabalhadaValidador(String mensagemValidacao) {
		this.mensagemValidacao = mensagemValidacao;
	}
	
	@Override
	public String getMenssagemValidacao() {
		return mensagemValidacao;
	}

}
