package repository;
import util.DBConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
public class BorrowRepository {
    public void borrowBook(int bookId, int userId) {
        String sql="INSERT INTO borrow_records(book_id, user_id, borrow_date) VALUES (?, ?, ?)";
        try (PreparedStatement ps=DBConnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, bookId);
            ps.setInt(2, userId);
            ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void returnBook(int bookId, int userId) {
        String sql="UPDATE borrow_records SET return_date = ? WHERE book_id = ? AND user_id = ? AND return_date IS NULL";
        try (PreparedStatement ps=DBConnection.getConnection().prepareStatement(sql)) {
            ps.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
            ps.setInt(2, bookId);
            ps.setInt(3, userId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
