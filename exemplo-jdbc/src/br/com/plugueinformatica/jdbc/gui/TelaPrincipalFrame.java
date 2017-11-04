package br.com.plugueinformatica.jdbc.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TelaPrincipalFrame extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent parent = FXMLLoader.
	            load(getClass().getResource("/br/com/plugueinformatica/jdbc/view/telaPrincipal.fxml"));
	        Scene scene = new Scene(parent);
	        stage.setScene(scene);
	        stage.setTitle("Tela Principal");
	        stage.show();		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
