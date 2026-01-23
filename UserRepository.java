package repository;
import model.User;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
public class UserRepository {
    public void addUser(User user) throws Exception {
        String sql="INSERT INTO users(name, email) VALUES (?, ?)";
        Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,user.name);
        ps.setString(2,user.email);
        ps.executeUpdate();
    }
}