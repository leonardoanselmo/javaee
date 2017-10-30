package br.com.plugueinformatica.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoUtil {

	private static ConexaoUtil conexaoUtil;

	public static ConexaoUtil getInstance() {
		if (conexaoUtil == null) {
			conexaoUtil = new ConexaoUtil();
		}
		return conexaoUtil;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/teste_devmedia", "root", "coelhoazul12");

	}
	
	public void listar() throws SQLException {
		Connection connection = null;
		try {
			connection = getConnection();
			
			String sql = "SELECT * FROM TB_PESSOA";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id_pessoa") + " - "
								+ resultSet.getString("nome"));				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}
	
	public static void main(String[] args) {
		try {			
			getInstance().listar();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}

}
