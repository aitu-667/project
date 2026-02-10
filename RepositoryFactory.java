package repository;

public class RepositoryFactory {
    public static BookRepository bookRepo() {
        return new BookRepository();
    }
    public static CategoryRepository categoryRepo() {
        return new CategoryRepository();
    }
    public static UserRepository userRepo() {
        return new UserRepository();
    }
}
