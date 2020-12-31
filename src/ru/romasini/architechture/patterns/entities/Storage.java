package ru.romasini.architechture.patterns.entities;

public class Storage {

    private Long Id;
    private String name;
    private User user;
    private Double balance;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Storage(Long id, String name, User user) {
        Id = id;
        this.name = name;
        this.user = user;
    }
}
