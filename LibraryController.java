package controller;

import service.LibraryService;
import entity.Member;

import java.util.Scanner;

public class LibraryController {
    private LibraryService service = new LibraryService();

    public void start() {
        Scanner sc = new Scanner(System.in);
        Member currentUser = new Member(); // role set elsewhere

        System.out.print("Enter book id: ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input");
            return;
        }

        int bookId = sc.nextInt();
        service.borrowBook(bookId, currentUser);
    }
}