package repository;

import db.DBConnection;
import java.sql.*;

public class BorrowingRepository {

    public void getFullBorrowingDescription(int id) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT bo.title, bo.author, c.name, m.name, b.borrow_date " +
                            "FROM borrowings b " +
                            "JOIN books bo ON b.book_id = bo.id " +
                            "JOIN categories c ON bo.category_id = c.id " +
                            "JOIN members m ON b.member_id = m.id " +
                            "WHERE b.id = ?"
            );
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println(
                        rs.getString(1) + " | " +
                                rs.getString(2) + " | " +
                                rs.getString(3) + " | " +
                                rs.getString(4)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
