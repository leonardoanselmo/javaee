package br.com.plugueinformatica.jdbc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.plugueinformatica.jdbc.bo.LoginBO;
import br.com.plugueinformatica.jdbc.dto.LoginDTO;
import br.com.plugueinformatica.jdbc.exception.NegocioException;
import br.com.plugueinformatica.jdbc.util.MensagensUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
	
	@FXML
	private TextField txtLogin;
	@FXML
	private PasswordField txtSenha;
	
	
	@Override
	public void initialize(URL url, ResourceBundle resources) {
					
	}
	
	@FXML
	protected void btnEntrarAction(ActionEvent evt) {
		LoginDTO loginDTO = new LoginDTO();
		loginDTO.setNome(txtLogin.getText());
		loginDTO.setSenha(txtSenha.getText());
		LoginBO loginBO = new LoginBO();
		try {
			if(loginBO.logar(loginDTO)) {
				MensagensUtil.addMsg(LoginController.this, "Login efetuado com sucesso.");
			} else {
				MensagensUtil.addMsg(LoginController.this, "Dados inválidos.");
			}
		} catch (NegocioException e) {		
			e.printStackTrace();
			MensagensUtil.addMsg(LoginController.this, e.getMessage());
		}
	}
	
	@FXML
	protected void btnSairAction(ActionEvent evt) {
		System.exit(0);
	}

}
