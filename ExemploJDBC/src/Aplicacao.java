import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Aplicacao {

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/teste_devmedia", "root",
					"coelhoazul12");
			Statement statement = connection.createStatement();
			statement.executeQuery("SELECT * FROM TB_PESSOA");
			ResultSet set = statement.getResultSet();
			
            while (set.next()) {
                System.out.printf("%d: %15s - %10s - %11s\n",
                        set.getInt("id_pessoa"),
                        set.getString("nome"),
                        set.getString("endereco"),
                        set.getString("cpf"));
            }

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

}
