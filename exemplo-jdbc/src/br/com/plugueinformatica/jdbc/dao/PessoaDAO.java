package br.com.plugueinformatica.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.plugueinformatica.jdbc.ConexaoUtil;
import br.com.plugueinformatica.jdbc.dto.PessoaDTO;
import br.com.plugueinformatica.jdbc.exception.PersistenciaException;

public class PessoaDAO implements GenericoDAO<PessoaDTO>{

	@Override
	public void inserir(PessoaDTO pessoaDTO) throws PersistenciaException {
		
		try {
			
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "INSERT INTO TB_PESSOA(NOME, CPF, ENDERECO, SEXO, DT_NASC)"+
					"VALUES(?, ?, ?, ?, ?)";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoaDTO.getNome());
			statement.setString(2, pessoaDTO.getCpf());
			statement.setString(3, pessoaDTO.getEndereco());
			statement.setString(4, String.valueOf(pessoaDTO.getSexo()));
			statement.setDate(5, new Date(pessoaDTO.getDtNascimento().getTime()));
			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();		
			throw new PersistenciaException(e.getMessage(), e);
		}
		
	}

	@Override
	public void atualizar(PessoaDTO pessoaDTO) throws PersistenciaException {
		
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "UPDATE TB_PESSOA SET NOME = ?, CPF = ?, ENDERECO = ?, SEXO = ?, DT_NASC = ?"+
						 " WHERE ID_PESSOA = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, pessoaDTO.getNome());
			statement.setString(2, pessoaDTO.getCpf());
			statement.setString(3, pessoaDTO.getEndereco());
			statement.setString(4, String.valueOf(pessoaDTO.getSexo()));
			statement.setDate(5, new Date(pessoaDTO.getDtNascimento().getTime()));
			statement.setInt(6, pessoaDTO.getIdPessoa());			
			
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		
	}

	@Override
	public void deletar(Integer idPessoa) throws PersistenciaException {
		
		try {
			
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "DELETE FROM TB_PESSOA WHERE ID_PESSOA = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, idPessoa);
			statement.execute();
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);			
		}
		
	}

	@Override
	public List<PessoaDTO> listarTodos() throws PersistenciaException {
		
		List<PessoaDTO> listaPesssoas = new ArrayList<PessoaDTO>();
		
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM TB_PESSOA";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				PessoaDTO pessoaDTO = new PessoaDTO();
				pessoaDTO.setIdPessoa(resultSet.getInt("id_pessoa"));
				pessoaDTO.setNome(resultSet.getString("nome"));
				pessoaDTO.setCpf(resultSet.getString("cpf"));
				pessoaDTO.setEndereco(resultSet.getString("endereco"));
				pessoaDTO.setSexo(resultSet.getString("sexo").charAt(0));
				pessoaDTO.setDtNascimento(resultSet.getDate("dt_nasc"));
				
				listaPesssoas.add(pessoaDTO);
			}
			
			connection.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		
		return listaPesssoas;
	}

	@Override
	public PessoaDTO buscarPorId(Integer id) throws PersistenciaException {
		PessoaDTO pessoaDTO = null;
		try {
			Connection connection = ConexaoUtil.getInstance().getConnection();
			
			String sql = "SELECT * FROM TB_PESSOA WHERE ID_PESSOA = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				pessoaDTO = new PessoaDTO();
				pessoaDTO.setIdPessoa(resultSet.getInt("id_pessoa"));
				pessoaDTO.setNome(resultSet.getString("nome"));
				pessoaDTO.setCpf(resultSet.getString("cpf"));
				pessoaDTO.setEndereco(resultSet.getString("endereco"));
				pessoaDTO.setSexo(resultSet.getString("sexo").charAt(0));
				pessoaDTO.setDtNascimento(resultSet.getDate("dt_nasc"));				
			}
			
			connection.close();			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistenciaException(e.getMessage(), e);
		}
		
		return pessoaDTO;
	}



}
