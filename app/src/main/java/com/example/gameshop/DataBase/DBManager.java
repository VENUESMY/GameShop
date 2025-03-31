package com.example.gameshop.DataBase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gameshop.Data.Developer;

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
}