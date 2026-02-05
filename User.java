package model;
public class User {
    private int id;
    private String name;
    private String role; // ADMIN or USER
    public User(int id, String name, String role) {
        this.id=id;
        this.name=name;
        this.role=role;
    }
    public int getId() { return id; }
    public String getRole() { return role; }
}