package br.com.plugueinformatica.jdbc.dao;

import java.util.List;

import br.com.plugueinformatica.jdbc.dto.LoginDTO;
import br.com.plugueinformatica.jdbc.exception.PersistenciaException;

public class LoginDAO implements GenericoDAO<LoginDTO>{
	
	public boolean logar(LoginDTO loginDTO) {
		
		return false;
	}

	@Override
	public void inserir(LoginDTO obj) throws PersistenciaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(LoginDTO obj) throws PersistenciaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Integer id) throws PersistenciaException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<LoginDTO> listarTodos() throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoginDTO buscarPorId(Integer id) throws PersistenciaException {
		// TODO Auto-generated method stub
		return null;
	}

}
