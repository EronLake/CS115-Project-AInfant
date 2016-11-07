package com.example.group.project_ainfant;

import android.util.Log;

import com.example.group.project_ainfant.PartsOfSpeech.Word;

import java.util.Hashtable;

/**
 * Created by eronj on 11/6/2016.
 */

public class Test {

    public Test(){}

    private static final String TAG = Test.class.getSimpleName();
    //test method for the constructObject function
    public boolean constructObjectTest() {

        //Creates method input
        String word = "dog";
        String PoS = "Noun";
        Hashtable<String, Integer> Tags = new Hashtable<String,Integer>(){{
            put("type", 0);
            put("propVImp", 3);
            put("singVPlur", 5);
        }};

        Word new_Word = new Word();
        //calls the construct object method
        new_Word = new_Word.constructObject(word, PoS, Tags);
        //checks output for desired results
        if (new_Word == null){
            Log.d(TAG, "constructObjectTest() returned false");
            return false;
        }else {
            Log.d(TAG, "constructObjectTest() returned true");
            Log.d(TAG, new_Word.name);
            return true;
        }
    }
}
