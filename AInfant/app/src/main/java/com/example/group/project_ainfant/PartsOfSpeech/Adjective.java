package com.example.group.project_ainfant.PartsOfSpeech;

/**
 * Created by eronj on 10/18/2016.
 */

public class Adjective {
    //used to determine posNegNeu value(may only be used later on)
    final private int POSITVE = 0;
    final private int NEGATIVE = 1;
    final private int NEUTRAL = 1;

    int posNegNeu;

    //if initialized with no parameters
    public void Adjective() {
        posNegNeu = NEUTRAL;
    }

    public void Adjective(int posNegNeu){
        //need to fill in
    }
}
