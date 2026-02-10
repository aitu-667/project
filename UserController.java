package controller;

import entity.User;
import service.UserService;

import java.util.Scanner;

public class UserController {

    private final UserService service = new UserService();
    private final Scanner sc = new Scanner(System.in);

    public void login() {
        System.out.print("Username: ");
        User user = service.login(sc.nextLine());

        System.out.println("Login successful!");
        System.out.println("Role: " + user.role);

        if (user.role.equals("ADMIN"))
            adminMenu();
        else
            userMenu();
    }

    private void adminMenu() {
        System.out.println("""
            --- ADMIN MENU ---
            1. Add book
            2. Add category
            3. Remove book
            4. View all users
            0. Logout
            Choose option:
            """);
    }

    private void userMenu() {
        System.out.println("""
            --- USER MENU ---
            1. Borrow book
            2. Return book
            3. View my borrowed books
            0. Logout
            Choose option:
            """);
    }
}
