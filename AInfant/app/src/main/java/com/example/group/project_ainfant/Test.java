package com.example.group.project_ainfant;

import com.example.group.project_ainfant.PartsOfSpeech.Word;

import java.util.Hashtable;

/**
 * Created by eronj on 11/6/2016.
 */

public class Test {

    //test method for the constructObject function
    public boolean constructObjectTest() {
        //Creates method input
        String word = "";
        String PoS = "";
        Hashtable<String, Integer> Tags = null;
        Tags.put("placehlder",1);

        Word new_Word = new Word();
        //calls the construct object method
        new_Word = new_Word.constructObject(word, PoS, Tags);
        //checks output for desired results
        if (new_Word == null){
            return false;
        }else {
            return true;
        }
    }
}
