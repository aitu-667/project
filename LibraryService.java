package service;

import entity.Member;
import repository.BookRepository;

public class LibraryService {
    private BookRepository bookRepo = new BookRepository();

    public void borrowBook(int bookId, Member member) {
        if (!member.getRole().equals("ADMIN")) {
            System.out.println("Access denied");
            return;
        }

        if (!bookRepo.isAvailable(bookId)) {
            System.out.println("Book not available");
            return;
        }

        System.out.println("Book borrowed successfully");
    }
}
