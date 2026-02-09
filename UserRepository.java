package repository;
import model.User;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserRepository {
    public List<User> getAllUsers() {
        List<User> users=new ArrayList<>();
        String sql="SELECT * FROM users";
        try (Statement st=DBConnection.getConnection().createStatement()) {
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("role")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    public User getUserById(int id) {
        String sql="SELECT * FROM users WHERE id=?";
        try (PreparedStatement ps=DBConnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("role")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void addUser(String name, String role) {
        String sql="INSERT INTO users(name, role) VALUES(?, ?)";
        try (PreparedStatement ps=DBConnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, role);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateUserRole(int userId, String role) {
        String sql="UPDATE users SET role=? WHERE id=?";
        try (PreparedStatement ps=DBConnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, role);
            ps.setInt(2, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
