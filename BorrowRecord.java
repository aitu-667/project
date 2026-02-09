package model;
import java.time.LocalDate;
public class BorrowRecord {
    private int id;
    private int bookId;
    private int userId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    public BorrowRecord(int bookId, int userId) {
        this.bookId=bookId;
        this.userId=userId;
        this.borrowDate=LocalDate.now();
    }
    public void setReturnDate(LocalDate date) {this.returnDate=date;}
}