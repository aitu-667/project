package repository;

import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "admin", "ADMIN"));
    }

    public User findByUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                return u;
            }
        }
        return null;
    }

    public List<User> findAll() {
        return users;
    }
}
