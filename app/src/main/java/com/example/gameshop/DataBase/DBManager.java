package com.example.gameshop.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

public class DBManager {

    private DBHelper dbHelper;
    private SQLiteOpenHelper sqLiteOpenHelper;

    public DBManager (Context context){
        dbHelper = new DBHelper(context);
    }

    public void openDb(){
        dbHelper.getWritableDatabase();
    }

    public void closeDb() {

    }

    //Блок разработчиков (Developer)
    public void addDeveloper(){

    }
}
