package com.kotrots.example.menus_example;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "lists_db";
    private static final int DATABASE_VERSION = 1;

    public static final String LIST_TABLE = "lists";
    public static final String LIST_COLUMN_ID = "id";
    public static final String LIST_COLUMN_NAME = "title";



    public static final String ITEM_TABLE = "items";
    public static final String ITEM_COLUMN_ID = "id";
    public static final String ITEM_COLUMN_NAME = "title";
    public static final String ITEM_COLUMN_QUANT = "quantity";
    public static final String ITEM_COLUMN_LID = "list_id";




    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + LIST_TABLE + " (" +
                LIST_COLUMN_ID + " integer primary key autoincrement, " +
                LIST_COLUMN_NAME + " text not null)");

        String sql = "CREATE TABLE " + ITEM_TABLE + " (" +
                ITEM_COLUMN_ID + "integer primary key autoincrement, " +
                ITEM_COLUMN_NAME + "text not null, " +
                ITEM_COLUMN_QUANT + "text not null, " +
                ITEM_COLUMN_LID + "integer not null)";
        Log.d("SQL_CREATE", sql);

        db.execSQL("CREATE TABLE " + ITEM_TABLE + " (" +
                ITEM_COLUMN_ID + " integer primary key autoincrement, " +
                ITEM_COLUMN_NAME + " text not null, " +
                ITEM_COLUMN_QUANT + " text not null, " +
                ITEM_COLUMN_LID + " integer not null)");

        ContentValues values = new ContentValues();
        values.put(LIST_COLUMN_NAME, "masoutis");
        db.insert(LIST_TABLE, null, values);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}