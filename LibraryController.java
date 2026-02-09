package controller;

import model.Book;
import model.User;
import service.LibraryService;

import java.sql.SQLException;
import java.util.List;

public class LibraryController {
    private LibraryService libraryService = new LibraryService();

    public User login(String username) {
        try {
            return libraryService.getUserByUsername(username);
        } catch (SQLException e) {
            System.out.println("Error during login: " + e.getMessage());
            return null;
        }
    }

    public List<Book> viewBooksByCategory(String category) {
        try {
            return libraryService.getBooksByCategory(category);
        } catch (SQLException e) {
            System.out.println("Error retrieving books: " + e.getMessage());
            return null;
        }
    }

    public boolean addBook(String title, String author, String category) {
        try {
            return libraryService.addBook(title, author, category);
        } catch (SQLException e) {
            System.out.println("Error adding book: " + e.getMessage());
            return false;
        }
    }

    public Book viewBookDetails(int bookId) {
        try {
            return libraryService.getBookById(bookId);
        } catch (SQLException e) {
            System.out.println("Error retrieving book details: " + e.getMessage());
            return null;
        }
    }
}
