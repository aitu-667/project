package controller;
import service.LibraryService;
import java.util.Scanner;
public class LibraryController {
    private LibraryService service=new LibraryService();
    public void start() throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("Library Management System");
        System.out.println("1.Borrow Book");
        System.out.println("2.Return Book");
        int choice=sc.nextInt();
        if (choice==1) {
            System.out.print("Enter User ID:");
            int userId=sc.nextInt();
            System.out.print("Enter Book ID:");
            int bookId=sc.nextInt();
            service.borrowBook(userId, bookId);
        }
        if (choice==2) {
            System.out.print("Enter Book ID:");
            int bookId=sc.nextInt();
            service.returnBook(bookId);
        }
    }
}