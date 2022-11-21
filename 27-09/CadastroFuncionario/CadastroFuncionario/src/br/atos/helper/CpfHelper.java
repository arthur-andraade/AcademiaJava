package br.atos.helper;

import java.util.Optional;
import java.util.stream.Stream;

import br.atos.enums.CpfValidador;
import br.atos.enums.IValidador;

public class CpfHelper {

	public static Optional<String> validarCpf(String cpf) {
		IValidador<String>[] validadores = CpfValidador.values();
		return Stream.of(validadores)
				.filter(validador -> validador.validar(cpf))
				.findFirst()
				.map(IValidador::getMenssagemValidacao);
	}

}
