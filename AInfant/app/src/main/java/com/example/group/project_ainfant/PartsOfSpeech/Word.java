package com.example.group.project_ainfant.PartsOfSpeech;

import java.util.Hashtable;

/**
 * Created by eronj on 10/18/2016.
 */

//Parent Class to parts of speech
public class Word {
    public String name;
    public String definition;



    public Word constructObject(String word, String PoS, Hashtable<String, Integer> Tags) {
        if (PoS.equals("Noun")) {
            Noun new_Word = new Noun(String word, Tags.get("type"), Tags.get("propVImp"), Tags.get("plurVSing"));
        } else if (PoS.equals("Verb")) {
            //Verb new_Word =
        } else if (PoS.equals("Verb")) {
            //Verb new_Word =
        }
        return new_Word;
    }
}

/*
    still need to create preposition and conjunction classes
*/