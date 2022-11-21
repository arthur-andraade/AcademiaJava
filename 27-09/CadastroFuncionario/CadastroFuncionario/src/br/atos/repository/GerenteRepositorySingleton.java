package br.atos.repository;

public class GerenteRepositorySingleton {
	
	private static GerenteRepository instancia = null;
	
	public static GerenteRepository getInstance() {
		if (instancia == null)
			instancia = new GerenteRepository();

		return instancia;
	}

}
