package com.example.gameshop.Data;

public class GamesPurchase {

    private int id;
    private int idGame;
    private int idPurchase;

    public GamesPurchase(int id, int idGame, int idPurchase) {
        this.id = id;
        this.idGame = idGame;
        this.idPurchase = idPurchase;
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

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }
}
