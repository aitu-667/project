package service;

import entity.User;
import repository.RepositoryFactory;

import java.util.List;

public class UserService {

    public User login(String username) {
        return RepositoryFactory.getUserRepository().findByUsername(username);
    }

    public List<User> getAllUsers() {
        return RepositoryFactory.getUserRepository().findAll();
    }
}
