package Controller;

import entity.User;
import service.UserService;

import java.util.Scanner;

public class UserController {

    private final UserService userService = new UserService();
    private final BookController bookController;
    private final CategoryController categoryController;

    public UserController(BookController b, CategoryController c) {
        this.bookController = b;
        this.categoryController = c;
    }

    public void login(Scanner sc) {
        System.out.print("Username: ");
        String username = sc.nextLine();

        User user = userService.login(username);
        if (user == null) {
            System.out.println("Invalid user");
            return;
        }

        System.out.println("Login successful!");
        System.out.println("Role: " + user.getRole());
        adminMenu(sc);
    }

    private void adminMenu(Scanner sc) {
        while (true) {
            System.out.println("--- ADMIN MENU ---");
            System.out.println("1. Add book");
            System.out.println("2. Add category");
            System.out.println("3. Remove book");
            System.out.println("4. View all users");
            System.out.println("0. Logout");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> bookController.addBook(sc);
                case 2 -> categoryController.addCategory(sc);
                case 3 -> bookController.removeBook(sc);
                case 4 -> userService.getAllUsers()
                        .forEach(u -> System.out.println(u.getUsername()));
                case 0 -> {
                    System.out.println("Logged out.");
                    return;
                }
            }
        }
    }
}
