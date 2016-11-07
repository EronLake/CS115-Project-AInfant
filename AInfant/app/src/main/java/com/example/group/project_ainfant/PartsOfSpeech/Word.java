package com.example.group.project_ainfant.PartsOfSpeech;

import java.util.Hashtable;

/**
 * Created by eronj on 10/18/2016.
 */

//Parent Class to parts of speech
public class Word {
    public static String name;
    public static String definition;


    //** Created by riamunoz || 11-06-2016 **//

    public Word constructObject(String word, String PoS, Hashtable<String, Integer> Tags) {
        //Checks PoS and constructs appropriate PoS with its given tags:
        if (PoS.equals("Noun")) {
            Noun new_Word = new Noun(word, Tags.get("type"), Tags.get("propVImp"), Tags.get("singVPlur"));
            return new_Word;
        } else if (PoS.equals("Verb")) {
            Verb new_Word = new Verb(word, Tags.get("actVPass"));
            return new_Word;
        } else if (PoS.equals("Adjective")){
            Adjective new_Word = new Adjective(word, Tags.get("posNegNeu_"));
            return new_Word;
        } else if (PoS.equals("Adverb")){
            Adverb new_Word = new Adverb(word, Tags.get("posNegNeu_"));
            return new_Word;
        } else if (PoS.equals("Pronoun")){
            Pronoun new_Word = new Pronoun(word, Tags.get("subVObj"), Tags.get("gender"), Tags.get("singVPlur"));
            return new_Word;
        } else if (PoS.equals("Determiner")){
            Determiner new_Word = new Determiner(word, Tags.get("singVPlur"));
            return new_Word;
        } else if (PoS.equals("Interjection")){
            Interjection new_Word = new Interjection(word, Tags.get("singVPlur"));
            return new_Word;
        }
        return null; // Returns null if PoS is not recognized
    }
}

/*
    still need to create preposition and conjunction classes
*/