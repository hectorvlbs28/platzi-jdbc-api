import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/JavaJDBCApi", "root", "0+%1,npHD7O@9vz^WV2p#3LCY10xA*S_");
            System.out.println("Connected to the database");

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM customers");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("customerNumber") + " " + resultSet.getString("customerName"));
            }

            String sql = ("INSERT INTO employees(employeeNumber,lastName,firstName,extension,email,officeCode,reportsTo,jobTitle) VALUES (100220,'Martinez','Liam','x5800','dmurphy@classicmodelcars.com','1',NULL,'President')");
            preparedStatement = connection.prepareStatement(sql);

            int rowsAffected = preparedStatement.executeUpdate();

            System.out.println("Rows affected: " + rowsAffected);
        } catch (Exception e) {
            System.out.println("An error occurred.");
            throw new RuntimeException(e);
        }
    }
}