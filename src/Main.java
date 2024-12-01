import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/JavaJDBCApi", "root", "0+%1,npHD7O@9vz^WV2p#3LCY10xA*S_");
            System.out.println("Connected to the database");

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name") + " " + resultSet.getString("email"));
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            throw new RuntimeException(e);
        }
    }
}