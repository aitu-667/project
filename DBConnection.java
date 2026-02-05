package util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
    private static Connection connection;
    private DBConnection() {}
    public static Connection getConnection() {
        if (connection==null) {
            try {
                connection=DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/ass4",
                        "postgres",
                        "nurken08"
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
}