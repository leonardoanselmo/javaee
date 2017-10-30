package br.com.plugueinformatica.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.plugueinformatica.jdbc.dto.PessoaDTO;

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
	
	public void inserir(PessoaDTO pessoaDTO) throws SQLException {
		
	}
	
	public void atualizar(PessoaDTO pessoaDTO) throws SQLException {
		
	}
	
	public void remover(Integer idPessoa) throws SQLException {
		
	}
	
	public static void main(String[] args) {
		try {			
			PessoaDTO dto = new PessoaDTO();
			dto.setIdPessoa(4);
			dto.setNome("Maria Lessa de Freitas Anselmo");
			dto.setEndereco("Rua Luiz da Silva Guerra, 13");
			dto.setCpf("12345678945");
			dto.setSexo('F');
			dto.setDtNascimento(new java.util.Date());
			
			getInstance().remover(dto.getIdPessoa());
			
			getInstance().listar();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}

}
