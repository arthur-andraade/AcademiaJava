package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoFactory {
	
	private static String USERNAME = "root";
	private static String PASSWORD = "atos";
	private static String URL_CONEXAO = "jdbc:mysql://localhost:3306/rh";
	
	public static Connection conectarComMySql() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conexao = DriverManager.getConnection(URL_CONEXAO, USERNAME, PASSWORD);
		
		return conexao;
	}
}
