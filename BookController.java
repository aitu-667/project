package controller;

import service.BookService;

public class BookController {
    private final BookService service = new BookService();

    public void listBooks() {
        System.out.println("--- ALL BOOKS ---");
        service.showBooks();
    }
}
