package br.com.plugueinformatica.jdbc.util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MensagensUtil {
			
	public static void exibirDialogoInformacao(String informacao) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Informação");
		alert.setHeaderText(null);
		alert.setContentText(informacao);
		
		alert.showAndWait();
	}

	public static void exibirDialogoErro(String erro) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Informação");
		alert.setHeaderText(null);
		alert.setContentText(erro);
		
		alert.showAndWait();
	}	

		
	
}
