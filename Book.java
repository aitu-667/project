package entity;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean available;
    private int categoryId;

    public boolean isAvailable() {
        return available;
    }
}
