import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginApp extends Application{
	
	private AnchorPane pane;
    private TextField txLogin;
    private PasswordField txSenha;
    private Button btEntrar, btSair;
    private static Stage stage;

	@Override
    public void start(Stage stage) throws Exception {
		initListeners();
        AnchorPane pane = new AnchorPane();
        pane.setPrefSize(400, 300);
        TextField txLogin = new TextField();
        txLogin.setPromptText("Digite aqui seu login");
        PasswordField txSenha = new PasswordField();
        txSenha.setPromptText("Digite aqui sua senha");
        Button btEntrar = new Button("Entrar");
        Button btSair = new Button("Sair");
        pane.getChildren().addAll(txLogin, txSenha, btEntrar, btSair);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
        
        txLogin.setLayoutX((pane.getWidth() - txLogin.getWidth()) / 2);
        txLogin.setLayoutY(50);
        txSenha.setLayoutX((pane.getWidth() - txSenha.getWidth()) / 2);
        txSenha.setLayoutY(100);
        btEntrar.setLayoutX(
            (pane.getWidth() - btEntrar.getWidth()) / 2);
        btEntrar.setLayoutY(150);
        btSair.setLayoutX((pane.getWidth() - btSair.getWidth()) / 2);
        btSair.setLayoutY(200);
	}

	
	 public static void main(String[] args) {
	        launch(args);
	}
	 
	private void initListeners() {		   
		 btSair.setOnAction(new EventHandler<ActionEvent>() {
		 @Override
		 public void handle(ActionEvent event) {
		      fecharAplicacao();
		 }
		});
	}
	 
	private void fecharAplicacao() {
		    System.exit(0);
	}

}
