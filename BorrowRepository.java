package repository;

import model.BorrowRecord;
import util.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BorrowRepository {

    public List<BorrowRecord> getBorrowRecordsByUserId(int userId) throws SQLException {
        List<BorrowRecord> records = new ArrayList<>();
        String sql = "SELECT id, user_id, book_id, borrow_date, return_date FROM borrow_records WHERE user_id = ?";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                BorrowRecord record = new BorrowRecord(
                        rs.getInt("id"),
                        rs.getInt("user_id"),
                        rs.getInt("book_id"),
                        rs.getDate("borrow_date").toLocalDate(),
                        rs.getDate("return_date") != null ? rs.getDate("return_date").toLocalDate() : null
                );
                records.add(record);
            }
        }
        return records;
    }

    public boolean addBorrowRecord(int userId, int bookId, LocalDate borrowDate) throws SQLException {
        String sql = "INSERT INTO borrow_records(user_id, book_id, borrow_date) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, bookId);
            stmt.setDate(3, Date.valueOf(borrowDate));
            return stmt.executeUpdate() > 0;
        }
    }
}
