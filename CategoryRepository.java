package repository;

import model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryRepository {
    private final List<Category> categories = new ArrayList<>();

    public CategoryRepository() {
        categories.add(new Category(1, "Fiction"));
        categories.add(new Category(2, "Science"));
        categories.add(new Category(3, "History"));
    }

    public List<Category> findAll() {
        return categories;
    }

    public Optional<Category> findById(int id) {
        return categories.stream().filter(c -> c.getId() == id).findFirst();
    }
}
