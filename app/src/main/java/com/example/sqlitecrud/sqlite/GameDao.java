package com.example.sqlitecrud.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqlitecrud.model.Game;

import java.util.ArrayList;
import java.util.List;

public class GameDao {
    private SQLiteDatabase db;

    public GameDao(Context context){
        DbHelper helper= new DbHelper(context);

        db=helper.getWritableDatabase();
    }
    @SuppressLint("Range")
    public List<Game> get(String sql, String ...selectArgs){
        List<Game> list= new ArrayList<>();
        Cursor cursor= db.rawQuery(sql,selectArgs);

        while (cursor.moveToNext()){
            Game gam=new Game();
            gam.setId(cursor.getString(cursor.getColumnIndex("id")));
            gam.setName(cursor.getString(cursor.getColumnIndex("name")));
            gam.setPrice(cursor.getFloat(cursor.getColumnIndex("price")));

            list.add(gam);
        }return list;
    }
    public List<Game> getAll(){
        String sql="SELECT * FROM game";
        return get(sql);
    }
    public Game getById(String id){
        String sql = "SELECT * FROM game WHERE id = ?";
        List<Game>list=get(sql,id);
        return list.get(0);
    }
    public long insert(Game gam){
        ContentValues values=new ContentValues();
        values.put("id",gam.getId());
        values.put("name",gam.getName());
        values.put("price",gam.getPrice());

        return db.insert("game",null,values);
    }
    public long update(Game gam){
        ContentValues values=new ContentValues();
        values.put("name",gam.getName());
        values.put("price",gam.getPrice());

        return db.update("game",values, "id=?",new  String[]{gam.getId()});
    }
    public int delete(String id){
        return db.delete("game","id=?",new String[]{id});
    }
}
