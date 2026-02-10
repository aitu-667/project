package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection connection;

    private DBConnection() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:postgresql://localhost:5432/oop+ass5",
                        "postgres",
                        "nurken08"
                );
            } catch (Exception e) {
                System.out.println("DB connection failed");
            }
        }
        return connection;
    }
}
