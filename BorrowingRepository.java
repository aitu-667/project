package repository;
import util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.LocalDate;
public class BorrowingRepository {
    public void borrowBook(int userId,int bookId) throws Exception {
        String sql="""
                INSERT INTO borrowings(user_id, book_id, borrow_date)
                VALUES (?, ?, ?)
                """;
        Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,userId);
        ps.setInt(2,bookId);
        ps.setDate(3,java.sql.Date.valueOf(LocalDate.now()));
        ps.executeUpdate();
    }
    public void returnBook(int bookId) throws Exception {
        String sql="""
                UPDATE borrowings
                SET return_date = ?
                WHERE book_id = ? AND return_date IS NULL
                """;
        Connection con=DBConnection.getConnection();
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setDate(1,java.sql.Date.valueOf(LocalDate.now()));
        ps.setInt(2,bookId);
        ps.executeUpdate();
    }
}