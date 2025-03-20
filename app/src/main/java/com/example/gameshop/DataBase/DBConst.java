package com.example.gameshop.DataBase;

public class DBConst {

    public static final String DATABASE_NAME = "GameShop.db";
    public static final int DATABASE_VERSION = 1;

    //Таблицы

    //Игры
    public static final String GAME_TABLE_NAME = "games";
    public static final String GAME_ID = "id";
    public static final String GAME_NAME = "name";
    public static final String GAME_DESCRIPTION = "description";
    public static final String GAME_PRICE = "price";
    public static final String GAME_ID_DEVELOPER = "idDeveloper";

    //Разработчики
    public static final String DEVELOPER_TABLE_NAME = "developers";
}
