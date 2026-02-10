package repository;

import entity.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {

    private static final List<Book> books = new ArrayList<>();

    static {
        books.add(new Book(1, "Harry Potter", "J.K. Rowling", "Fantasy"));
    }

    public List<Book> findAll() {
        return books;
    }

    public void save(Book book) {
        books.add(book);
    }

    public boolean deleteById(int id) {
        return books.removeIf(b -> b.getId() == id);
    }

    public Book findById(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }
}
