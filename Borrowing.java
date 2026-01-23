package model;
import java.time.LocalDate;
public class Borrowing {
    public int id;
    public int userId;
    public int bookId;
    public LocalDate borrowDate;
    public LocalDate returnDate;
}