package com.example.group.project_ainfant.PartsOfSpeech;

/**
 * Created by eronj on 10/18/2016.
 */


public class Adverb extends Word {

    //used to determine posNegNeu value(may only be used later on)
    final private int POSITVE = 0;
    final private int NEGATIVE = 1;
    final private int NEUTRAL = 1;

    public static int posNegNeu;

    public Adverb(String name_, int posNegNeu_){
        //allows to also use the word constructor as defult(may need to change)
        super();
        //Constructor for Adverb
        this.name = name_;
        this.posNegNeu = posNegNeu_;

    }
}
