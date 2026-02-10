
package service;

import dto.FullBookDTO;
import entity.Book;
import repository.RepositoryFactory;

import java.util.ArrayList;
import java.util.List;

public class BookService {

    public List<Book> getAllBooks() {
        return RepositoryFactory.getBookRepository().findAll();
    }

    public void addBook(String title, String author, String category) {
        int id = getAllBooks().size() + 1;
        RepositoryFactory.getBookRepository()
                .save(new Book(id, title, author, category));
    }

    public boolean removeBook(int id) {
        return RepositoryFactory.getBookRepository().deleteById(id);
    }

    public FullBookDTO getBookDetails(int id) {
        Book b = RepositoryFactory.getBookRepository().findById(id);
        if (b == null) return null;
        return new FullBookDTO(b.getId(), b.getTitle(), b.getAuthor(), b.getCategory());
    }
}
