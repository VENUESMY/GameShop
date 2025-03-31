package com.example.gameshop.Data;

public class GameCategory {

    private int id;
    private int idGame;
    private int idCategory;

    public GameCategory(int id, int idGame, int idCategory) {
        this.id = id;
        this.idGame = idGame;
        this.idCategory = idCategory;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdGame() {
        return idGame;
    }

    public void setIdGame(int idGame) {
        this.idGame = idGame;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
