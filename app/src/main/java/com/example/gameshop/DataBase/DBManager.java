package com.example.gameshop.DataBase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gameshop.Data.Category;
import com.example.gameshop.Data.Developer;
import com.example.gameshop.Data.Game;
import com.example.gameshop.Data.Purchase;

import java.util.ArrayList;
import java.util.List;

public class DBManager {

    private DBHelper dbHelper;
    private SQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase db;

    public DBManager (Context context){
        dbHelper = new DBHelper(context);
    }

    public void openDb(){
        dbHelper.getWritableDatabase();
    }

    public void closeDb() {
        dbHelper.close();
    }

    //Блок разработчиков (Developer)
    public void addDeveloper(Developer developer){
        ContentValues cv = new ContentValues();
        cv.put(DBConst.DEVELOPER_NAME, developer.getName());
        cv.put(DBConst.DEVELOPER_DESCRIPTION, developer.getDescription());
        db.insert(DBConst.DEVELOPER_TABLE_NAME, null, cv);
    }

    public void changeDeveloper(Developer developer){
        ContentValues cv = new ContentValues();
        cv.put(DBConst.DEVELOPER_NAME, developer.getName());
        cv.put(DBConst.DEVELOPER_DESCRIPTION, developer.getDescription());
        db.update(DBConst.DEVELOPER_TABLE_NAME, cv,
                DBConst.DEVELOPER_ID + " = " + developer.getId(), null);
    }
    public void deleteDeveloper(Developer developer){
        db.delete(DBConst.DEVELOPER_TABLE_NAME,
                DBConst.DEVELOPER_ID + " = " + developer.getId(),null);
    }

    @SuppressLint("Range")
    public List<Developer> getAllDevelopers(){
        List<Developer> developers = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * From " + DBConst.DEVELOPER_TABLE_NAME,null);
        while (cursor.moveToNext()){
            Developer developer = new Developer();
            developer.setId(cursor.getInt(cursor.getColumnIndex(DBConst.DEVELOPER_ID)));
            developer.setName(cursor.getString(cursor.getColumnIndex(DBConst.DEVELOPER_NAME)));
            developer.setDescription(cursor.getString(cursor.getColumnIndex(DBConst.DEVELOPER_DESCRIPTION)));
            developers.add(developer);
        }
        cursor.close();
        return developers;
    }
    //Блок категории

    public void addCategory(Category category){
        ContentValues cv = new ContentValues();
        cv.put(DBConst.CATEGORY_NAME, category.getName());
        db.insert(DBConst.CATEGORY_TABLE_NAME, null, cv);
    }

    public void changeCategory(Category category){
        ContentValues cv = new ContentValues();
        cv.put(DBConst.CATEGORY_NAME, category.getName());
        db.update(DBConst.CATEGORY_TABLE_NAME, cv,
                DBConst.CATEGORY_ID + " = " + category.getId(), null);
    }

    public void deleteCategory(Category category){
        db.delete(DBConst.CATEGORY_TABLE_NAME,
                DBConst.CATEGORY_ID + " = " + category.getId(), null);
    }

    @SuppressLint("Range")
    public List<Category> getAllCategory(){
        List<Category> categories = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * From " + DBConst.CATEGORY_TABLE_NAME,null);
        while (cursor.moveToNext()){
            Category category = new Category();
            category.setId(cursor.getInt(cursor.getColumnIndex(DBConst.CATEGORY_ID)));
            category.setName(cursor.getString(cursor.getColumnIndex(DBConst.CATEGORY_NAME)));
            categories.add(category);
        }
        cursor.close();
        return categories;
    }
    //Блок игр

    public void addGame(Game game){
        ContentValues cv = new ContentValues();
        cv.put(DBConst.GAME_NAME, game.getName());
        cv.put(DBConst.GAME_DESCRIPTION, game.getDescription());
        cv.put(DBConst.GAME_PRICE, game.getPrice());
        cv.put(DBConst.GAME_ID_DEVELOPER, game.getIdDeveloper());
        db.insert(DBConst.GAME_TABLE_NAME, null, cv);
    }

    public void changeGame(Game game){
        ContentValues cv = new ContentValues();
        cv.put(DBConst.GAME_NAME, game.getName());
        cv.put(DBConst.GAME_DESCRIPTION, game.getDescription());
        cv.put(DBConst.GAME_PRICE, game.getPrice());
        cv.put(DBConst.GAME_ID_DEVELOPER, game.getIdDeveloper());
        db.update(DBConst.GAME_TABLE_NAME, cv,
                DBConst.GAME_ID + " = " + game.getId(), null);
    }

    @SuppressLint("Range")
    public List<Game> getAllGame(){
        List<Game> games = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * From " + DBConst.GAME_TABLE_NAME,null);
        while (cursor.moveToNext()){
            Game game = new Game();
            game.setId(cursor.getInt(cursor.getColumnIndex(DBConst.GAME_ID)));
            game.setName(cursor.getString(cursor.getColumnIndex(DBConst.GAME_NAME)));
            game.setDescription(cursor.getString(cursor.getColumnIndex(DBConst.GAME_DESCRIPTION)));
            game.setPrice(cursor.getInt(cursor.getColumnIndex(DBConst.GAME_PRICE)));
            game.setIdDeveloper(cursor.getInt(cursor.getColumnIndex(DBConst.GAME_ID_DEVELOPER)));
            games.add(game);
        }
        cursor.close();
        return games;
    }
    //Блок покупок

    public void addPurchase(Purchase purchase){
        ContentValues cv = new ContentValues();
        cv.put(DBConst.PURCHASE_DATE, purchase.getDate());
        cv.put(DBConst.PURCHASE_TOTAL_PRICE, purchase.getTotalPrice());
        db.insert(DBConst.PURCHASE_TABLE_NAME, null, cv);
    }

    public void changePurchase(Purchase purchase){
        ContentValues cv = new ContentValues();
        cv.put(DBConst.PURCHASE_DATE, purchase.getDate());
        cv.put(DBConst.PURCHASE_TOTAL_PRICE, purchase.getTotalPrice());
        db.update(DBConst.PURCHASE_TABLE_NAME, cv,
                DBConst.PURCHASE_ID + " = " + purchase.getId(), null);
    }

    @SuppressLint("Range")
    public List<Purchase> getAllPurchase(){
        List<Purchase> purchases = new ArrayList<>();
        Cursor cursor = db.rawQuery("Select * From " + DBConst.PURCHASE_TABLE_NAME,null);
        while (cursor.moveToNext()){
            Purchase purchase = new Purchase();
            purchase.setId(cursor.getInt(cursor.getColumnIndex(DBConst.PURCHASE_ID)));
            purchase.setDate(cursor.getInt(cursor.getColumnIndex(DBConst.PURCHASE_DATE)));
            purchase.setTotalPrice(cursor.getInt(cursor.getColumnIndex(DBConst.PURCHASE_TOTAL_PRICE)));
            purchases.add(purchase);
        }
        cursor.close();
        return purchases;
    }
}