package dto;

public class FullBookDTO {
    public int id;
    public String title;
    public String category;

    @Override
    public String toString() {
        return "ID: " + id +
                "\nTitle: " + title +
                "\nCategory: " + category +
                "\n---------------------";
    }
}
