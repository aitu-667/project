package repository;
import model.Book;
import util.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class BookRepository {
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Statement st=DBConnection.getConnection().createStatement()) {
            ResultSet rs=st.executeQuery(sql);
            while (rs.next()) {
                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("category_id"),
                        rs.getBoolean("available")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    public void updateAvailability(int bookId, boolean status) {
        String sql="UPDATE books SET available=? WHERE id=?";
        try (PreparedStatement ps=DBConnection.getConnection().prepareStatement(sql)) {
            ps.setBoolean(1, status);
            ps.setInt(2, bookId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addBook(String title, String author, int categoryId) {
        String sql="INSERT INTO books(title, author, category_id, available) VALUES(?, ?, ?, true)";
        try (PreparedStatement ps=DBConnection.getConnection().prepareStatement(sql)) {
            ps.setString(1, title);
            ps.setString(2, author);
            ps.setInt(3, categoryId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}