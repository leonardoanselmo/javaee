package br.com.plugueinformatica.jdbc.controller;

import java.net.URL;
import java.util.ResourceBundle;

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
		
	}
	
	@FXML
	protected void btnSairAction(ActionEvent evt) {
		System.exit(0);
	}

}
