package repository;
import model.Book;
import util.DBConnection;
import java.sql.*;
public class BookRepository {
    public void addBook(Book book) throws Exception {
        String sql="INSERT INTO books(title, author, available) VALUES (?, ?, ?)";
        Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setString(1,book.title);
        ps.setString(2,book.author);
        ps.setBoolean(3,true);
        ps.executeUpdate();
    }
    public Book findById(int id) throws Exception {
        String sql="SELECT * FROM books WHERE id =?";
        Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        if (rs.next()) {
            Book b=new Book();
            b.id=rs.getInt("id");
            b.title=rs.getString("title");
            b.author=rs.getString("author");
            b.available=rs.getBoolean("available");
            return b;
        }
        return null;
    }
    public void updateAvailability(int id,boolean available) throws Exception {
        String sql="UPDATE books SET available =? WHERE id =?";
        Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setBoolean(1,available);
        ps.setInt(2,id);
        ps.executeUpdate();
    }
}