package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQL {
	private String database = "loja";
	private String user = "root";
	private String password = "root";
	
	private String path = "jdbc:mysql://localhost:3306/";
	
	public Connection connect() {
		//Carregar o driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Conectado ao MySQL com sucesso!");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection connection = null;
		//Conectar
		try {
			 connection = DriverManager.getConnection(path+database, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}
}
