package service;
import model.Book;
import repository.BookRepository;
import repository.BorrowingRepository;
public class LibraryService {
    private BookRepository bookRepo=new BookRepository();
    private BorrowingRepository borrowingRepo=new BorrowingRepository();
    public void borrowBook(int userId,int bookId) throws Exception {
        Book book=bookRepo.findById(bookId);
        if (book==null) {
            System.out.print("Book not found");
            return;
        }
        if (!book.available) {
            System.out.print("Book already borrowed");
            return;
        }
        borrowingRepo.borrowBook(userId,bookId);
        bookRepo.updateAvailability(bookId,false);
        System.out.print("Book borrowed successfully");
    }
    public void returnBook(int bookId) throws Exception {
        borrowingRepo.returnBook(bookId);
        bookRepo.updateAvailability(bookId,true);
        System.out.print("Book returned");
    }
}