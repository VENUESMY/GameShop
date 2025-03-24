package com.example.gameshop.DataBase;

public class DBConst {

    public static final String DATABASE_NAME = "GameShop.db";
    public static final int DATABASE_VERSION = 1;

    //Tables

    //Games
    public static final String GAME_TABLE_NAME = "Games";
    public static final String GAME_ID = "id";
    public static final String GAME_NAME = "name";
    public static final String GAME_DESCRIPTION = "description";
    public static final String GAME_PRICE = "price";
    public static final String GAME_ID_DEVELOPER = "idDeveloper";

    //Developers
    public static final String DEVELOPER_TABLE_NAME = "Developers";
    public static final String DEVELOPER_ID = "id";
    public static final String DEVELOPER_NAME = "name";
    public static final String DEVELOPER_DESCRIPTION = "description";

    //Purchases
    public static final String PURCHASE_TABLE_NAME = "Purchases";
    public static final String PURCHASE_ID = "id";
    public static final String PURCHASE_DATE = "date";
    public static final String PURCHASE_TOTAL_PRICE = "totalPrice";

    //Categories
    public static final String CATEGORY_TABLE_NAME = "Category";
    public static final String CATEGORY_ID = "id";
    public static final String CATEGORY_NAME = "name";

    //Game categories
    public static final String GAME_CATEGORIES_TABLE_NAME = "GameCategories";
    public static final String GAME_CATEGORIES_ID = "id";
    public static final String GAME_CATEGORIES_ID_GAME = "idGame";
    public static final String GAME_CATEGORIES_ID_CATEGORY = "idCategory";

    //Purchase games
    public static final String PURCHASE_GAMES_TABLE_NAME = "PurchaseGames";
    public static final String PURCHASE_GAMES_ID = "id";
    public static final String PURCHASE_GAMES_ID_GAME = "idGame";
    public static final String PURCHASE_GAMES_ID_PURCHASE = "idPurchase";

    //Create tables
    public static final String CREATE_TABLE_DEVELOPER = "create table if not exists" +
            DEVELOPER_TABLE_NAME + " ( " + DEVELOPER_ID + " integer primary key autoincrement, " +
            DEVELOPER_NAME + " text, " + DEVELOPER_DESCRIPTION + " text )";

    public static final String CREATE_TABLE_GAME = "create table if not exists" +
            GAME_TABLE_NAME + " ( " + GAME_ID + " integer primary key autoincrement, " +
            GAME_NAME + " text, " + GAME_DESCRIPTION + " text, " + GAME_PRICE + " integer, " + GAME_ID_DEVELOPER +
            " integer, " +
            "FOREIGN KEY (" + GAME_ID_DEVELOPER + ") REFERENCES " + DEVELOPER_TABLE_NAME + " (" +
            DEVELOPER_ID + ") ON DELETE CASCADE)";

    public static final String CREATE_TABLE_PURCHASE = "create table if not exists" +
            PURCHASE_TABLE_NAME + " ( " + PURCHASE_ID + " integer primary key autoincrement, " +
            PURCHASE_DATE + " text, " + PURCHASE_TOTAL_PRICE + " integer )";

    public static final String CREATE_TABLE_CATEGORY = "create table if not exists" +
            CATEGORY_TABLE_NAME + " ( " + CATEGORY_ID + " integer primary key autoincrement, " +
            CATEGORY_NAME + " text )";

    public static final String CREATE_TABLE_GAMES_CATEGORIES = "create table if not exists" +
            GAME_CATEGORIES_TABLE_NAME + " ( " + GAME_CATEGORIES_ID + " integer primary key autoincrement, " +
            GAME_CATEGORIES_ID_GAME + " integer " + GAME_CATEGORIES_ID_CATEGORY + " integer " +
           "FOREIGN KEY (" + GAME_CATEGORIES_ID_GAME + ") REFERENCES " + GAME_TABLE_NAME + " (" +
            GAME_ID + ") ON DELETE CASCADE," +
            "FOREIGN KEY (" + GAME_CATEGORIES_ID_CATEGORY + ") REFERENCES " + CATEGORY_TABLE_NAME + " (" +
            CATEGORY_ID + ") ON DELETE CASCADE)";

    public static final String CREATE_TABLE_PURCHASE_GAMES = "create table if not exists" +
            PURCHASE_GAMES_TABLE_NAME + " ( " + PURCHASE_GAMES_ID + " integer primary key autoincrement, " +
            PURCHASE_GAMES_ID_GAME + " integer, " + PURCHASE_GAMES_ID_PURCHASE + " integer, " +
            "FOREIGN KEY (" + PURCHASE_GAMES_ID_GAME + ") REFERENCES " + GAME_TABLE_NAME + " (" +
            GAME_ID + ") ON DELETE CASCADE," +
            "FOREIGN KEY (" + PURCHASE_GAMES_ID_PURCHASE + ") REFERENCES " + PURCHASE_GAMES_TABLE_NAME + " (" +
            PURCHASE_ID + ") ON DELETE CASCADE)";

    //Delete tables
    public static final String DROP_TABLE_DEVELOPER = "Drop table if exists " + DEVELOPER_TABLE_NAME;

    public static final String DROP_TABLE_GAME = "Drop table if exists" + GAME_TABLE_NAME;

    public static final String DROP_TABLE_CATEGORY = "Drop table if exists" + CATEGORY_TABLE_NAME;

    public static final String DROP_TABLE_PURCHASE = "Drop table if exists" + PURCHASE_TABLE_NAME;

    public static final String DROP_TABLE_GAMES_CATEGORIES = "Drop table if exists" + PURCHASE_GAMES_TABLE_NAME;

    public static final String DROP_TABLE_PURCHASE_GAMES = "Drop table if exists" + GAME_CATEGORIES_TABLE_NAME;
}
