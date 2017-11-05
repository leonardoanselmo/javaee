package br.com.plugueinformatica.jdbc.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class TelaPrincipalController implements Initializable{
	
	@FXML
    private TextField txtNome;

	@FXML
    private TextField txtEndereco;
	
	@FXML
    private TextField txtCPF;

    @FXML
    private ToggleGroup grupo;

    @FXML
    private RadioButton rbtMasculino;

	@FXML
    private RadioButton rbtFeminino;

    @FXML
    private DatePicker dtNascimento;
	
	@FXML
    private Button btnSalvar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	@FXML
	void salvarPessoa() {
    		limparFields();
    	}
	
	private void limparFields() {
		txtNome.clear();
		txtCPF.clear();
		txtEndereco.clear();
		rbtMasculino.setSelected(true);
		dtNascimento.setValue(null);		
	}

}
