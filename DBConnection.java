package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static DBConnection instance;
    private Connection connection;

    private static final String URL =
            "jdbc:postgresql://localhost:5432/ass5";
    private static final String USER = "postgres";
    private static final String PASSWORD = "nurken08"; // pgAdmin пароль

    private DBConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DBConnection getInstance() {
        if (instance == null)
            instance = new DBConnection();
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
