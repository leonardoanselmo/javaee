package br.com.plugueinformatica.jdbc.bo;

import br.com.plugueinformatica.jdbc.dao.PessoaDAO;
import br.com.plugueinformatica.jdbc.dto.PessoaDTO;
import br.com.plugueinformatica.jdbc.exception.NegocioException;


public class PessoaBO {
	
	public void cadastrar(PessoaDTO pessoaDTO) throws NegocioException {
		
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoaDAO.inserir(pessoaDTO);			
		} catch (Exception exception) {
			throw new NegocioException(exception.getMessage()); 			
		}
		
		
	}
	
	

}
