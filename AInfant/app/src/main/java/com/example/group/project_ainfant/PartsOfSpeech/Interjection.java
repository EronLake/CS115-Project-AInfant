package com.example.group.project_ainfant.PartsOfSpeech;

/**
 * Created by eronj on 10/18/2016.
 */

public class Interjection {
    //used to determine subVObj value
    final private int GREETING = 0;
    final private int EXCLAMATION = 1;

    //if greeting or exclamation
    int type;

    //if initialized with no parameters
    public void Interjection() {
        type = EXCLAMATION;
    }

    public void Interjection(int type){
        //need to fill in
    }
}
