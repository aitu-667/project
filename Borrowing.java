package entity;
import java.time.LocalDate;
public class Borrowing {
    private int id;
    private int bookId;
    private int memberId;
    private LocalDate borrowDate;
    public Borrowing(int bookId, int memberId) {
        this.bookId=bookId;
        this.memberId=memberId;
        this.borrowDate=LocalDate.now();
    }
}