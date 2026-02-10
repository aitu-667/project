package repository;

import config.DBConnection;
import dto.FullBookDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    public List<FullBookDTO> findAll() {
        List<FullBookDTO> list = new ArrayList<>();

        String sql = """
            SELECT b.id, b.title, c.name AS category
            FROM books b
            JOIN categories c ON b.category_id = c.id
        """;

        try (Statement st = DBConnection.getInstance()
                .getConnection().createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                FullBookDTO dto = new FullBookDTO();
                dto.id = rs.getInt("id");
                dto.title = rs.getString("title");
                dto.category = rs.getString("category");
                list.add(dto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
