package service;

import repository.RepositoryFactory;

public class BookService {

    public void showBooks() {
        RepositoryFactory.bookRepo()
                .findAll()
                .forEach(System.out::println); // lambda
    }
}
