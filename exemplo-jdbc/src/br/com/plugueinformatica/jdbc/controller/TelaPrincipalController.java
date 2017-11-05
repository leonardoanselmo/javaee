package br.com.plugueinformatica.jdbc.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import br.com.plugueinformatica.jdbc.dao.PessoaDAO;
import br.com.plugueinformatica.jdbc.dto.PessoaDTO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;

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
    		PessoaDTO pessoaDTO = new PessoaDTO();
    		pessoaDTO.setNome(txtNome.getText());
    		pessoaDTO.setCpf(txtCPF.getText());
    		pessoaDTO.setEndereco(txtEndereco.getText());    		   
    		
    		char sexo = rbtMasculino.isSelected()?'M':'F';
    		pessoaDTO.setSexo(sexo);
    		
    		pessoaDTO.setDtNascimento(Date.valueOf(dtNascimento.getValue()));
    		
    		PessoaDAO pessoaDAO = new PessoaDAO();
    		try {
    			pessoaDAO.inserir(pessoaDTO);
    			exibirDialogoInformacao("Pessoa cadastrado com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			exibirDialogoErro("Falha ao cadastrar a pessoa.");
		}
		
    		
    	}
	
	public void limparFields() {
		txtNome.clear();
		txtCPF.clear();
		txtEndereco.clear();
		rbtMasculino.setSelected(true);
		dtNascimento.setValue(null);		
	}
	

    public void exibirDialogoInformacao(String informacao) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Informação");
		alert.setHeaderText(null);
		alert.setContentText(informacao);
		
		alert.showAndWait();
	}

	public void exibirDialogoErro(String erro) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Informação");
		alert.setHeaderText(null);
		alert.setContentText(erro);
		
		alert.showAndWait();
	}	


}
