package br.atos.dao;

import java.sql.Connection;

import config.ConexaoFactory;

public abstract class AbstractDao {

	public Connection getConexao() {
		try {
			return ConexaoFactory.conectarComMySql();
		} catch (Exception e) {
			throw new RuntimeException("Erro ao conectar");
		}
	}
	
}
