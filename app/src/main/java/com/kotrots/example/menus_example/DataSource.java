package com.kotrots.example.menus_example;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import java.util.ArrayList;

public class DataSource {
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;

    private String[] listsAllColums = {SQLiteHelper.LIST_COLUMN_ID, SQLiteHelper.LIST_COLUMN_NAME};

    public DataSource(Context context){
        dbHelper = new SQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public ArrayList<List> selectAllLists(){
        ArrayList<List> lists = new ArrayList<>();
        Cursor cursor = database.query(SQLiteHelper.LIST_TABLE, listsAllColums, null, null, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            List list = new List();
            list.setId(cursor.getInt(0));
            list.setTitle(cursor.getString(1));


            lists.add(list);
            cursor.moveToNext();
        }

        return lists;
    }

    public void insertList(String title){
        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.LIST_COLUMN_NAME, title);
        database.insert(SQLiteHelper.LIST_TABLE, null, values);
    }
}
