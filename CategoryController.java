package Controller;

import service.CategoryService;

import java.util.Scanner;

public class CategoryController {

    private final CategoryService service = new CategoryService();

    public void addCategory(Scanner sc) {
        System.out.print("Category name: ");
        String name = sc.nextLine();
        service.addCategory(name);
        System.out.println("Category added.");
    }
}
