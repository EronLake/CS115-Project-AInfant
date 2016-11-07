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
        db.execSQL("create table input_table " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "INPUT text,"
                + "speech text)");

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
        db.execSQL("create table pronouns " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "WORD text, TYPE text, GENDER text, VALUE text)"
        );
    }

    public void initializeVerb(SQLiteDatabase db){
        db.execSQL("create table verbs " + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, "
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
        //put it in the words table as well
        values.clear();
        values.put("WORD", adjective.name);
        values.put("TYPE", adjective.definition);
        db.insert("words", null, values);
        db.close(); // Closing database connection

    }

    public void addAdverb(Adverb adverb){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("WORD", adverb.name); // The word
        values.put("TYPE", adverb.posNegNeu); // Adjective Type

        // Inserting Row
        db.insert("adverbs", null, values);
        //put it in the words table as well
        values.clear();
        values.put("WORD", adverb.name);
        values.put("TYPE", adverb.definition);
        db.insert("words", null, values);
        db.close(); // Closing database connection

    }

    public void addDeterminer(Determiner determiner){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("WORD", determiner.name); // The word
        values.put("TYPE", determiner.singVPlur); // determiner Type
        // Inserting Row
        db.insert("determiners", null, values);
        //put it in the words table as well
        values.clear();
        values.put("WORD", determiner.name);
        values.put("TYPE", determiner.definition);
        db.insert("words", null, values);
        db.close(); // Closing database connection
    }

    public void addInterjection(Interjection interjection){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("WORD", interjection.name); // The word
        values.put("TYPE", interjection.type); // determiner Type
        // Inserting Row
        db.insert("interjections", null, values);

        //put it in the words table as well
        values.clear();
        values.put("WORD", interjection.name);
        values.put("TYPE", interjection.definition);
        db.insert("words", null, values);
        db.close(); // Closing database connection
    }

    public void addNoun(Noun noun){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("WORD", noun.name); // The word
        values.put("TYPE", noun.type); // Noun type
        values.put("PROPER", noun.propVImp); // Noun type
        // Inserting Row
        db.insert("nouns", null, values);
        //put it in the words table as well
        values.clear();
        values.put("WORD", noun.name);
        values.put("TYPE", noun.definition);
        db.insert("words", null, values);
        db.close(); // Closing database connection

    }

    public void addPronoun(Pronoun pronoun){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("WORD", pronoun.name); // The word
        values.put("TYPE", pronoun.subVObj); // Pronoun type
        values.put("GENDER", pronoun.gender); // Pronoun type
        values.put("VALUE",pronoun.singVPlur);
        // Inserting Row
        db.insert("pronouns", null, values);

        //put it in the words table as well
        values.clear();
        values.put("WORD", pronoun.name);
        values.put("TYPE", pronoun.definition);
        db.insert("words", null, values);
        db.close(); // Closing database connection

    }

    public void addVerb(Verb verb){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("WORD", verb.name); // The word
        values.put("TYPE", verb.actVPass); // verb Type
        // Inserting Row
        db.insert("verbs", null, values);

        //put it in the words table as well
        values.clear();
        values.put("WORD", verb.name);
        values.put("TYPE", verb.definition);
        db.insert("words", null, values);

        db.close(); // Closing database connection
    }


    public boolean insertData(String input){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //putting the user input into the INPUT column
        contentValues.put("INPUT", input);
        long result = db.insert(TABLE_NAME,null,contentValues);
        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public boolean ifExists(String exists) {
        String query = "Select * FROM words WHERE TYPE" + " =  \"" + exists + "\"";
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
