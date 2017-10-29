import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Aplicacao {

	public static void main(String[] args) {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/code_editora", "root",
					"coelhoazul12");
			Statement statement = connection.createStatement();
			statement.executeQuery("SELECT * FROM users");
			ResultSet set = statement.getResultSet();
			
            while (set.next()) {
                System.out.printf("%d: %15s - %10s\n",
                        set.getInt("id"),
                        set.getString("name"),
                        set.getString("email"));
            }

		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}

}
