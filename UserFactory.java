package factory;

import model.Role;
import model.User;

public class UserFactory {

    private static int userIdCounter = 1;

    public static User createUser(String name, Role role) {
        return new User(userIdCounter++, name, role);
    }
}
