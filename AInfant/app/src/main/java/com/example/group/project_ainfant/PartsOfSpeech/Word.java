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

    public Word(String word, String speech) {
        this.name = word;
        this.definition = speech;
    }

    public Word() {
    }


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
        }  else if (PoS.equals("Conjunction")){
            Conjunction new_Word = new Conjunction (word, Tags.get("cordVSub"), Tags.get("andVBut"));
            return new_Word;
        }  else if (PoS.equals("Preposition")){
            Preposition new_Word = new Preposition(word, Tags.get("type"));
            return new_Word;
        }
        return null; // Returns null if PoS is not recognized
    }

    public Word constructObjectNoTags(String word, String PoS) {
        //Checks PoS and constructs appropriate PoS with its given tags:
        if (PoS.equals("noun")) {
            Noun new_Word = new Noun(word, 0, 3, 5);
            return new_Word;
        } else if (PoS.equals("verb")) {
            Verb new_Word = new Verb(word, 0);
            return new_Word;
        } else if (PoS.equals("adjective")){
            Adjective new_Word = new Adjective(word, 0);
            return new_Word;
        } else if (PoS.equals("adverb")){
            Adverb new_Word = new Adverb(word,0);
            return new_Word;
        } else if (PoS.equals("pronoun")){
            Pronoun new_Word = new Pronoun(word, 0, 2, 5);
            return new_Word;
        } else if (PoS.equals("determiner")){
            Determiner new_Word = new Determiner(word, 0);
            return new_Word;
        } else if (PoS.equals("interjection")){
            Interjection new_Word = new Interjection(word, 0);
            return new_Word;
        }  else if (PoS.equals("conjunction")){
            Conjunction new_Word = new Conjunction (word, 0, 2);
            return new_Word;
        }  else if (PoS.equals("preposition")){
            Preposition new_Word = new Preposition(word, 0);
            return new_Word;
        }
        return null; // Returns null if PoS is not recognized
    }
}

/*
    still need to create preposition and conjunction classes
*/