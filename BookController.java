package Controller;

import dto.FullBookDTO;
import entity.Book;
import service.BookService;

import java.util.Scanner;

public class BookController {

    private final BookService service = new BookService();

    public void viewAllBooks() {
        System.out.println("--- ALL BOOKS ---");
        for (Book b : service.getAllBooks()) {
            System.out.println(b.getId() + ". " + b.getTitle());
        }
    }

    public void addBook(Scanner sc) {
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();
        System.out.print("Category: ");
        String category = sc.nextLine();

        service.addBook(title, author, category);
        System.out.println("Book added successfully.");
    }

    public void removeBook(Scanner sc) {
        System.out.print("Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (service.removeBook(id))
            System.out.println("Book removed.");
        else
            System.out.println("Book not found.");
    }

    public void viewBookDetails(Scanner sc) {
        System.out.print("Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        FullBookDTO dto = service.getBookDetails(id);
        if (dto == null) {
            System.out.println("Book not found.");
            return;
        }

        System.out.println("ID: " + dto.id);
        System.out.println("Title: " + dto.title);
        System.out.println("Author: " + dto.author);
        System.out.println("Category: " + dto.category);
    }
}
