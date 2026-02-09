package repository;

import model.Book;
import model.Category;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    public List<Book> getBooksByCategory(String categoryName) throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT b.id, b.title, b.author, c.id AS c_id, c.name AS c_name " +
                "FROM books b JOIN categories c ON b.category_id = c.id WHERE c.name = ?";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoryName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Category category = new Category(rs.getInt("c_id"), rs.getString("c_name"));
                Book book = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), category);
                books.add(book);
            }
        }
        return books;
    }

    public boolean addBook(String title, String author, String categoryName) throws SQLException {
        int categoryId = getCategoryId(categoryName);
        if (categoryId == -1) {
            categoryId = addCategory(categoryName);
            if (categoryId == -1) {
                return false;
            }
        }
        String sql = "INSERT INTO books(title, author, category_id) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, title);
            stmt.setString(2, author);
            stmt.setInt(3, categoryId);
            return stmt.executeUpdate() > 0;
        }
    }

    private int getCategoryId(String categoryName) throws SQLException {
        String sql = "SELECT id FROM categories WHERE name = ?";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, categoryName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        }
        return -1;
    }

    private int addCategory(String categoryName) throws SQLException {
        String sql = "INSERT INTO categories(name) VALUES(?)";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, categoryName);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }

    public Book getBookById(int bookId) throws SQLException {
        String sql = "SELECT b.id, b.title, b.author, c.id AS c_id, c.name AS c_name " +
                "FROM books b JOIN categories c ON b.category_id = c.id WHERE b.id = ?";
        try (Connection conn = DBConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bookId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Category category = new Category(rs.getInt("c_id"), rs.getString("c_name"));
                return new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), category);
            }
        }
        return null;
    }
}
