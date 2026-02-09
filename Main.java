import controller.LibraryController;
import model.Book;
import model.User;
import util.InputValidator;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static LibraryController controller = new LibraryController();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Library Management System ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        User user = controller.login(username);
        if (user == null) {
            System.out.println("User not found!");
            return;
        }
        System.out.println("Welcome, " + user.getUsername() + "! Your role: " + user.getRole());

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. View Book Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Search books by category? (yes/no): ");
                    String byCategory = scanner.nextLine();
                    if (byCategory.equalsIgnoreCase("yes")) {
                        System.out.print("Enter category name: ");
                        String category = scanner.nextLine();
                        if (!InputValidator.isNotEmpty(category)) {
                            System.out.println("Category name cannot be empty.");
                            break;
                        }
                        List<Book> books = controller.viewBooksByCategory(category);
                        if (books != null && !books.isEmpty()) {
                            System.out.println("Books in category '" + category + "':");
                            for (Book book : books) {
                                System.out.println(book.getId() + ". " + book.getTitle());
                            }
                        } else {
                            System.out.println("No books found in this category.");
                        }
                    } else {
                        System.out.println("Returning to menu.");
                    }
                    break;

                case "2":
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter category name: ");
                    String category = scanner.nextLine();

                    if (!InputValidator.isNotEmpty(title) || !InputValidator.isNotEmpty(author) || !InputValidator.isNotEmpty(category)) {
                        System.out.println("All fields are required.");
                        break;
                    }

                    boolean added = controller.addBook(title, author, category);
                    if (added) {
                        System.out.println("Book added successfully.");
                    } else {
                        System.out.println("Failed to add book.");
                    }
                    break;

                case "3":
                    System.out.print("Enter book ID to view details: ");
                    String bookIdStr = scanner.nextLine();

                    if (!InputValidator.isPositiveInteger(bookIdStr)) {
                        System.out.println("Invalid book ID.");
                        break;
                    }

                    int bookId = Integer.parseInt(bookIdStr);
                    Book book = controller.viewBookDetails(bookId);
                    if (book != null) {
                        System.out.println("\nBook Details:");
                        System.out.println("Book ID: " + book.getId());
                        System.out.println("Title: " + book.getTitle());
                        System.out.println("Author: " + book.getAuthor());
                        System.out.println("Category: " + book.getCategory().getName());
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;

                case "4":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
