package repository;

import entity.User;

public class UserRepository {

    public User login(String username) {
        User u = new User();
        u.username = username;
        u.role = username.equals("admin") ? "ADMIN" : "USER";
        return u;
    }
}
