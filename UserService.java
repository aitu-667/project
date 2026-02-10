package service;

import entity.User;
import repository.RepositoryFactory;

public class UserService {
    public User login(String username) {
        return RepositoryFactory.userRepo().login(username);
    }
}
