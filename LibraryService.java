package service;

import model.Book;
import model.User;
import repository.BookRepository;
import repository.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class LibraryService {
    private BookRepository bookRepository = new BookRepository();
    private UserRepository userRepository = new UserRepository();

    public List<Book> getBooksByCategory(String category) throws SQLException {
        return bookRepository.getBooksByCategory(category);
    }

    public boolean addBook(String title, String author, String category) throws SQLException {
        return bookRepository.addBook(title, author, category);
    }

    public Book getBookById(int id) throws SQLException {
        return bookRepository.getBookById(id);
    }

    public User getUserByUsername(String username) throws SQLException {
        return userRepository.getUserByUsername(username);
    }
}
