
import controller.BookController;
import controller.UserController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookController bookCtrl = new BookController();
        UserController userCtrl = new UserController();

        while (true) {
            System.out.println("""
                === LIBRARY MANAGEMENT SYSTEM ===
                1. View all books
                2. Login
                0. Exit
                Choose option:
                """);

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> bookCtrl.listBooks();
                case 2 -> userCtrl.login();
                case 0 -> System.exit(0);
            }
        }
    }
}
