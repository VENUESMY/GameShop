package com.example.gameshop.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(@Nullable Context context) {
        super(context, DBConst.DATABASE_NAME, null, DBConst.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBConst.CREATE_TABLE_CATEGORY);
        db.execSQL(DBConst.CREATE_TABLE_DEVELOPER);
        db.execSQL(DBConst.CREATE_TABLE_PURCHASE);
        db.execSQL(DBConst.CREATE_TABLE_GAME);
        db.execSQL(DBConst.CREATE_TABLE_PURCHASE_GAMES);
        db.execSQL(DBConst.CREATE_TABLE_GAMES_CATEGORIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(DBConst.CREATE_TABLE_CATEGORY);
        db.execSQL(DBConst.CREATE_TABLE_DEVELOPER);
        db.execSQL(DBConst.CREATE_TABLE_PURCHASE);
        db.execSQL(DBConst.CREATE_TABLE_GAME);
        db.execSQL(DBConst.CREATE_TABLE_PURCHASE_GAMES);
        db.execSQL(DBConst.CREATE_TABLE_GAMES_CATEGORIES);
        onCreate(db);
    }
}
