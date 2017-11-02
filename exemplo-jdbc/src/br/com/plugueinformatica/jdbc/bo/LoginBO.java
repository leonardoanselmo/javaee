package br.com.plugueinformatica.jdbc.bo;

import br.com.plugueinformatica.jdbc.dao.LoginDAO;
import br.com.plugueinformatica.jdbc.dto.LoginDTO;
import br.com.plugueinformatica.jdbc.exception.NegocioException;

public class LoginBO {
	
	public boolean logar(LoginDTO loginDTO) throws NegocioException {
		boolean resultado = false;
		try {
			
			if (loginDTO.getNome() == null || "".equals(loginDTO.getNome())) {				
				throw new NegocioException("Login obrigatório!");				
			} else if (loginDTO.getSenha() == null || "".equals(loginDTO.getSenha())){
				throw new NegocioException("Senha obrigatória!");
			} else {
				LoginDAO loginDAO = new LoginDAO();
				
				resultado = loginDAO.logar(loginDTO);
			}
			
		} catch (Exception e) {
			throw new NegocioException(e.getMessage());
		}
		return resultado;
	}

}
