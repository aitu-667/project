package repository;

import model.User;
import model.Role;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository {

    public User getUserByUsername(String username) throws SQLException {
        String sql = "SELECT id, username, role FROM users WHERE username = ?";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String roleStr = rs.getString("role");
                Role role = Role.valueOf(roleStr.toUpperCase());
                return new User(rs.getInt("id"), rs.getString("username"), role);
            }
        }
        return null;
    }
}
