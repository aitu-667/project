
package repository;

import entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    private static final List<Category> categories = new ArrayList<>();

    public void save(Category category) {
        categories.add(category);
    }

    public List<Category> findAll() {
        return categories;
    }
}
