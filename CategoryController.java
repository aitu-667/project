package controller;

import service.CategoryService;
import java.util.Scanner;

public class CategoryController {
    private final CategoryService service = new CategoryService();

    public void addCategory() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter category name: ");
        service.addCategory(sc.nextLine());
    }
}
