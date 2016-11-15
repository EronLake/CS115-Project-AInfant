package com.example.group.project_ainfant.PartsOfSpeech;

/**
 * Created by eronj on 10/18/2016.
 */


public class Adverb extends Word {

    //used to determine posNegNeu value(may only be used later on)
    final private int POSITVE = 0;
    final private int NEGATIVE = 1;
    final private int NEUTRAL = 2;

    public static int posNegNeu;

    public Adverb(String name_, int posNegNeu_){

        //Constructor for Adverb
        this.name = name_;
        this.posNegNeu = posNegNeu_;

    }
}
