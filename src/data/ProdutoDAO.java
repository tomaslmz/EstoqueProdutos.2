package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Produto;

public class ProdutoDAO {
	
	public void salvar(Produto p) {
		ConexaoSQL connection = new ConexaoSQL();
		connection.connect();
		Connection id = connection.connect();
		
		String sql = "INSERT INTO produto(nome, preco, estoque) VALUES (?, ?, ?)";
		//Preparando o banco de dados a receber um comando
		try {
			PreparedStatement command = id.prepareStatement(sql);
			command.setString(1, p.getNome());
			command.setFloat(2, p.getPreco());
			command.setInt(3, p.getEstoque());
			
			command.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			id.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletar(Produto p) {
		ConexaoSQL connection = new ConexaoSQL();
		connection.connect();
		Connection id = connection.connect();
		
		String sql = "DELETE FROM produto WHERE nome = ?";
		
		
		try {
			PreparedStatement command = id.prepareStatement(sql);
			command.setString(1, p.getNome());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			id.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
