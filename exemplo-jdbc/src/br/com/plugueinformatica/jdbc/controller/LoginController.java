package br.com.plugueinformatica.jdbc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.com.plugueinformatica.jdbc.bo.LoginBO;
import br.com.plugueinformatica.jdbc.dto.LoginDTO;
import br.com.plugueinformatica.jdbc.exception.NegocioException;
import br.com.plugueinformatica.jdbc.util.MensagensUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
	
	@FXML
	private TextField txtLogin = new TextField(); 
	@FXML
	private PasswordField txtSenha = new PasswordField();
	@FXML
	private Button btnEntrar, btnSair;
	
	
	@Override
	public void initialize(URL url, ResourceBundle resources) {		
		btnEntrar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//System.exit(0);
				btnEntrarAction();
			}
		});
		
		btnSair.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
		
		
	}
	
	public void mostrarMensagem() {
		if (txtLogin.getText().equals("admin")){
			JOptionPane.showMessageDialog(null, "ok");
		}
	}
	
	
	//@FXML
	//public void btnEntrarAction(ActionEvent evt) {
	public void btnEntrarAction() {
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
	
	/*
	@FXML
	protected void btnSairAction(ActionEvent evt) {		
		System.exit(0);
	}
	*/

}
