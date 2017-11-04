package br.com.plugueinformatica.jdbc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.plugueinformatica.jdbc.bo.LoginBO;
import br.com.plugueinformatica.jdbc.dto.LoginDTO;
import br.com.plugueinformatica.jdbc.exception.NegocioException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {
	

	@FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Button btnSair;

    @FXML
    private Button btnEntrar;	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	@FXML
    void entrarNoSistema() {
		LoginDTO loginDTO = new LoginDTO();
		
		loginDTO.setNome(txtLogin.getText());
		loginDTO.setSenha(txtSenha.getText());
		LoginBO loginBO = new LoginBO();
		try {
			if(loginBO.logar(loginDTO)) {
				exibirDialogoInformacao("Login efetuado com sucesso.");
			} else {
				exibirDialogoErro("Dados inválidos.");
			}
		} catch (NegocioException e) {		
			e.printStackTrace();
			exibirDialogoErro(e.getMessage());
		}

    }

    @FXML
    void sairDoSistema() {
    		System.exit(0);
    }    
    
    private void exibirDialogoInformacao(String informacao) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Informação");
    		alert.setHeaderText(null);
    		alert.setContentText(informacao);
    		
    		alert.showAndWait();
    }
    
    private void exibirDialogoErro(String erro) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Informação");
		alert.setHeaderText(null);
		alert.setContentText(erro);
		
		alert.showAndWait();
    }	

}
