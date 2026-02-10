package service;

import repository.RepositoryFactory;

public class CategoryService {
    public void addCategory(String name) {
        RepositoryFactory.categoryRepo().add(name);
        System.out.println("Category added successfully!");
    }
}
