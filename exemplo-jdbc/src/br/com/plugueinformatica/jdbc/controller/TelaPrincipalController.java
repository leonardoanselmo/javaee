package br.com.plugueinformatica.jdbc.controller;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

import br.com.plugueinformatica.jdbc.bo.PessoaBO;
import br.com.plugueinformatica.jdbc.dao.PessoaDAO;
import br.com.plugueinformatica.jdbc.dto.PessoaDTO;
import br.com.plugueinformatica.jdbc.exception.PersistenciaException;
import br.com.plugueinformatica.jdbc.util.MensagensUtil;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

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
	
	@FXML
    private TableView<PessoaDTO> Pessoas;	

	@FXML
    private TableColumn<PessoaDTO, Integer> idPessoa;
	
    @FXML
    private TableColumn<PessoaDTO, String> nomePessoa;
    
    @FXML
    private TableColumn<PessoaDTO, String> cpfPessoa;
	
	@FXML
    private TableColumn<PessoaDTO, String> enderecoPessoa;	

    @FXML
    private TableColumn<PessoaDTO, Character> sexoPessoa;

    @FXML
    private TableColumn<PessoaDTO, Date> dtNascimentoPessoa;    
	
	@Override	
	public void initialize(URL location, ResourceBundle resources) {
		
		listagemPessoas();
		
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
	
	private void limparFields() {
		txtNome.clear();
		txtCPF.clear();
		txtEndereco.clear();
		rbtMasculino.setSelected(true);
		dtNascimento.setValue(null);		
	}
	
	private void listagemPessoas() {
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		
		idPessoa.setCellValueFactory(new PropertyValueFactory<>("idPessoa"));
		nomePessoa.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpfPessoa.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		enderecoPessoa.setCellValueFactory(new PropertyValueFactory<>("endereco"));
		sexoPessoa.setCellValueFactory(new PropertyValueFactory<>("sexo"));
		dtNascimentoPessoa.setCellValueFactory(new PropertyValueFactory<>("dtNascimento"));
		
		try {					
			List<PessoaDTO> resultado = pessoaDAO.listarTodos();
			Pessoas.setItems(FXCollections.observableList(resultado));
		} catch (PersistenciaException e) {
			e.printStackTrace();
		}		
		
	}

   

}
