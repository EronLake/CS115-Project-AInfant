package com.example.group.project_ainfant.PartsOfSpeech;

/**
 * Created by eronj on 11/14/2016.
 */

public class Preposition extends Word {
    //used to determine type value
    final private int LOCATION = 0;
    final private int TIME = 1;
    final private int OTHER = 2;

    public static int type;

    public Preposition(String name_, int type_){

        //Constructor for verb
        this.name = name_;
        this.type = type_;
    }
}
