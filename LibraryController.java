package controller;
import service.LibraryService;
import java.util.Scanner;
public class LibraryController {
    private final LibraryService service=new LibraryService();
    private final Scanner scanner=new Scanner(System.in);
    private final int demoUserId=1; // demo user
    public void start() {
        while (true) {
            System.out.println("\n Library Management System ");
            System.out.println("1. Show all books");
            System.out.println("2. Add new book");
            System.out.println("3. Borrow book");
            System.out.println("4. Return book");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> service.showBooks();
                case 2 -> {
                    System.out.print("Enter title: ");
                    String title=scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author=scanner.nextLine();
                    service.addBook(title, author, 1); // demo categoryId
                }
                case 3 -> {
                    System.out.print("Enter Book ID: ");
                    int bookId=scanner.nextInt();
                    service.borrowBook(bookId, demoUserId);
                }
                case 4 -> {
                    System.out.print("Enter Book ID: ");
                    int bookId=scanner.nextInt();
                    service.returnBook(bookId, demoUserId);
                }
                case 5 -> {
                    System.out.println("Thank you for using Library Management System!");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }
        }
    }
}
