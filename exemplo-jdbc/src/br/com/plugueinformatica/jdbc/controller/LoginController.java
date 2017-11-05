package br.com.plugueinformatica.jdbc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.plugueinformatica.jdbc.bo.LoginBO;
import br.com.plugueinformatica.jdbc.dto.LoginDTO;
import br.com.plugueinformatica.jdbc.exception.NegocioException;
import br.com.plugueinformatica.jdbc.gui.TelaPrincipalFrame;
import br.com.plugueinformatica.jdbc.util.MensagensUtil;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
				MensagensUtil.exibirDialogoInformacao("Login efetuado com sucesso.");
				Stage stage = (Stage) btnEntrar.getScene().getWindow();				
				stage.close();
				try {					
		            new TelaPrincipalFrame().start(new Stage());		            
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			} else {
				MensagensUtil.exibirDialogoErro("Dados inválidos.");
			}
		} catch (NegocioException e) {		
			e.printStackTrace();
			MensagensUtil.exibirDialogoErro(e.getMessage());
		}

    }

    @FXML
    void sairDoSistema() {
    		System.exit(0);
    }    
   
}
