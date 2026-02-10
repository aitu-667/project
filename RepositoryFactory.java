package repository;

public class RepositoryFactory {

    private static BookRepository bookRepository;
    private static CategoryRepository categoryRepository;
    private static UserRepository userRepository;

    public static BookRepository getBookRepository() {
        if (bookRepository == null)
            bookRepository = new BookRepository();
        return bookRepository;
    }

    public static CategoryRepository getCategoryRepository() {
        if (categoryRepository == null)
            categoryRepository = new CategoryRepository();
        return categoryRepository;
    }

    public static UserRepository getUserRepository() {
        if (userRepository == null)
            userRepository = new UserRepository();
        return userRepository;
    }
}
