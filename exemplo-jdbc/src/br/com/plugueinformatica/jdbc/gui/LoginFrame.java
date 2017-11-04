package br.com.plugueinformatica.jdbc.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginFrame extends Application{
	
	@Override
	public void start(Stage stage) throws Exception {
		Parent parent = FXMLLoader.
	            load(getClass().getResource("/br/com/plugueinformatica/jdbc/view/login.fxml"));
	        Scene scene = new Scene(parent);
	        stage.setScene(scene);
	        stage.setTitle("Tela de Login");
	        stage.show();	        
		
	}
		
	public static void main(String[] args) {
	        launch(args);
	}

}
