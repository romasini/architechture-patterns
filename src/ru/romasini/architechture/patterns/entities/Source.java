package ru.romasini.architechture.patterns.entities;

import ru.romasini.architechture.patterns.utils.TypeOperationItem;

public class Source {
    private Long id;
    private User user;
    private String name;
    private TypeOperationItem type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeOperationItem getType() {
        return type;
    }

    public void setType(TypeOperationItem type) {
        this.type = type;
    }

    public Source(Long id, User user, String name, TypeOperationItem type) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Source{" +
                "name='" + name + '\'' +
                '}';
    }
}
