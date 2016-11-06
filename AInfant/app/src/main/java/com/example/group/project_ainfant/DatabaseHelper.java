package com.example.group.project_ainfant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.group.project_ainfant.PartsOfSpeech.*;
/**
 * Created by MichaelHa1 on 10/17/16.
 * Expanded by Gamiel Sanchez
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "MyDBName.db";
    public static final String TABLE_NAME = "input_table";
    public static final String Table_Input = "INPUT";

    public static final String word_row_speech = "SPEECH";
    public static final String word_row_plural = "PLURAL";
    public static final String word_row_proper = "PROPER";
    public static final String word_row_depend = "DEPEND";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        //Create Tables
        initializeWords(db);
        initializeAdjective(db);
        initializeAdverb(db);
        initializeDeterminer(db);
        initializeInterjection(db);
        initializeNoun(db);
        initializePronoun(db);
        initializeVerb(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        //db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }



    //Initialize table
    //-------------------------------------------------------------------------------------

    public void initializeWords(SQLiteDatabase db){
        db.execSQL("create table words " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "WORD text, TYPE text)"
        );
    }

    public void initializeAdjective(SQLiteDatabase db){
        db.execSQL("create table adjectives " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "WORD text, TYPE text)"
        );
    }

    public void initializeAdverb(SQLiteDatabase db){
        db.execSQL("create table adverbs " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "WORD text, TYPE text)"
        );
    }

    public void initializeDeterminer(SQLiteDatabase db){
        db.execSQL("create table determiners " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "WORD text, TYPE text)"
        );
    }

    public void initializeInterjection(SQLiteDatabase db){
        db.execSQL("create table interjections " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "WORD text, TYPE text)"
        );
    }

    public void initializeNoun(SQLiteDatabase db){
        db.execSQL("create table nouns " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "WORD text, TYPE text, PROPER text)"
        );
    }

    public void initializePronoun(SQLiteDatabase db){
        db.execSQL("create table words " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "WORD text, TYPE text, Gender text, VALUE text)"
        );
    }

    public void initializeVerb(SQLiteDatabase db){
        db.execSQL("create table words " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "WORD text, TYPE text)"
        );
    }

    //-------------------------------------------------------------------------------------

    //Insert Functions
    public void addAdjective(Adjective adjective){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("WORD", adjective.name); // The word
        values.put("TYPE", adjective.posNegNeu); // Adjective Type

        // Inserting Row
        db.insert("adjectives", null, values);
        db.close(); // Closing database connection

    }

    public void addNoun(Noun noun){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("WORD", noun.name); // The word
        values.put("TYPE", noun.type); // Noun type
        values.put("Proper", noun.propVImp); // Noun type

        // Inserting Row
        db.insert("nouns", null, values);
        db.close(); // Closing database connection

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
