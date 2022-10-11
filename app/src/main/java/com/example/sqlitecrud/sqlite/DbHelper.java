package com.example.sqlitecrud.sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public static final String DB_NAME="Demo";
    public static final int DB_VERSION=2;

    public DbHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql= "CREATE TABLE game(id text primary key, name text not null, "+
                "price real not null)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql ="DROP TABLE IF EXISTS game";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
}
