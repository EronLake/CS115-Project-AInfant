package com.example.group.project_ainfant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MichaelHa1 on 10/17/16.
 * Expanded by Gamiel Sanchez
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    //create database
    public static final String DATABASE_NAME = "MyDBName.db";

    //create word table
    public static final String TABLE_NAME = "word_table";

    //create rows
    public static final String word_row_word = "WORD";
    public static final String word_row_speech = "SPEECH";
    public static final String word_row_plural = "PLURAL";
    public static final String word_row_proper = "PROPER";
    public static final String word_row_depend = "DEPEND";


    public static final String Table_Input = "INPUT";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        //Create Input Table
        db.execSQL("create table input_table " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "INPUT text, "
                + word_row_word + "BIT, "
                + word_row_speech + "BIT, "
                + word_row_plural + "BIT, "
                + word_row_proper + "BIT,"
                + word_row_depend + "BIT)"
                );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }


    public boolean insertData(String input){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //putting the user input into the INPUT column
        contentValues.put(Table_Input, input);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean ifExists(String exists) {
        String query = "Select * FROM " + TABLE_NAME + " WHERE " + Table_Input + " =  \"" + exists + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;
    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
}
