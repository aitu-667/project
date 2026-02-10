import Controller.BookController;
import Controller.CategoryController;
import Controller.UserController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BookController bookController = new BookController();
        CategoryController categoryController = new CategoryController();
        UserController userController =
                new UserController(bookController, categoryController);

        while (true) {
            System.out.println("=== LIBRARY MANAGEMENT SYSTEM ===");
            System.out.println("1. View all books");
            System.out.println("2. Login");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> bookController.viewAllBooks();
                case 2 -> userController.login(sc);
                case 0 -> {
                    System.out.println("Goodbye!");
                    return;
                }
            }
        }
    }
}
