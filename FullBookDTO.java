package dto;

public class FullBookDTO {
    public int id;
    public String title;
    public String author;
    public String category;

    public FullBookDTO(int id, String title, String author, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
    }
}
