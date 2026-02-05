package service;
import model.Book;
import repository.BookRepository;
import repository.BorrowRepository;
import java.util.List;
public class LibraryService {
    private final BookRepository bookRepo=new BookRepository();
    private final BorrowRepository borrowRepo=new BorrowRepository();
    public void showBooks() {
        List<Book> books=bookRepo.getAllBooks();
        books.forEach(System.out::println);
    }
    public void addBook(String title, String author, int categoryId) {
        bookRepo.addBook(title, author, categoryId);
        System.out.println("Book added successfully!");
    }
    public void borrowBook(int bookId, int userId) {
        bookRepo.updateAvailability(bookId, false);
        borrowRepo.borrowBook(bookId, userId);
        System.out.println("Book borrowed successfully!");
    }
    public void returnBook(int bookId, int userId) {
        bookRepo.updateAvailability(bookId, true);
        borrowRepo.returnBook(bookId, userId);
        System.out.println("Book returned successfully!");
    }
}