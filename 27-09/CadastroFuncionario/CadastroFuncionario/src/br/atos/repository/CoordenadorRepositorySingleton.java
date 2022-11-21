package br.atos.repository;

public class CoordenadorRepositorySingleton {
	
	private static CoordenadorRepository instancia = null;
	
	public static CoordenadorRepository getInstance() {
		if (instancia == null)
			instancia = new CoordenadorRepository();

		return instancia;
	}
	
}
