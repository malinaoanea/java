import java.sql.Connection;
import  java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static void connect() {
        Connection connection = null;
        try {
            String url = "database.db";

            try {
                connection = (Connection) DriverManager.getConnection(url);
                System.out.println("Connection to database has succeeded.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        connect();
    }

}
