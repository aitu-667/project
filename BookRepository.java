package repository;

import entity.Book;
import db.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    public List<Book> getAvailableBooks() {
        List<Book> books = new ArrayList<>();

        // DB fetch logic here

        books.stream()
                .filter(Book::isAvailable)
                .forEach(System.out::println);

        return books;
    }

    public boolean isAvailable(int bookId) {
        if (bookId <= 0)
            throw new IllegalArgumentException("Invalid book id");

        return true;
    }
}
