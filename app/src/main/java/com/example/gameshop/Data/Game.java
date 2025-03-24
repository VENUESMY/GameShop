package com.example.gameshop.Data;

public class Game {

    private int id;
    private String name;
    private String description;
    private int price;
    private int idDeveloper;

    public Game(int id, String name, String description, int price, int idDeveloper) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.idDeveloper = idDeveloper;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getIdDeveloper() {
        return idDeveloper;
    }

    public void setIdDeveloper(int idDeveloper) {
        this.idDeveloper = idDeveloper;
    }
}
