package br.com.plugueinformatica.jdbc.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import br.com.plugueinformatica.jdbc.bo.PessoaBO;
import br.com.plugueinformatica.jdbc.dto.PessoaDTO;
import br.com.plugueinformatica.jdbc.util.MensagensUtil;
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
    		
    		PessoaDTO pessoaDTO = new PessoaDTO();
    		try {
	    		pessoaDTO.setNome(txtNome.getText());
	    		pessoaDTO.setCpf(txtCPF.getText());
	    		pessoaDTO.setEndereco(txtEndereco.getText());    		   
	    		
	    		char sexo = rbtMasculino.isSelected()?'M':'F';
	    		pessoaDTO.setSexo(sexo);
	    		
	    		pessoaDTO.setDtNascimento(Date.valueOf(dtNascimento.getValue()));
	    		
	    		PessoaBO pessoaBO = new PessoaBO();    		
    			pessoaBO.cadastrar(pessoaDTO);
    			MensagensUtil.exibirDialogoInformacao("Pessoa cadastrado com sucesso.");
    			
		} catch (Exception e) {
			e.printStackTrace();
			MensagensUtil.exibirDialogoErro("Falha ao cadastrar a pessoa.");
		} finally {
			limparFields();
		}
		
    		
    	}
	
	public void limparFields() {
		txtNome.clear();
		txtCPF.clear();
		txtEndereco.clear();
		rbtMasculino.setSelected(true);
		dtNascimento.setValue(null);		
	}
	

   

}
