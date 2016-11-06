package com.example.group.project_ainfant.PartsOfSpeech;

/**
 * Created by eronj on 10/18/2016.
 */

public class Adverb {
    //used to determine posNegNeu value(may only be used later on)
    final private int POSITVE = 0;
    final private int NEGATIVE = 1;
    final private int NEUTRAL = 1;

    public static int posNegNeu;

    //if initialized with no parameters
    public void Adverb() {
        posNegNeu = NEUTRAL;
    }

    public void Adverb(int posNegNeu){
        //need to fill in
    }
}
