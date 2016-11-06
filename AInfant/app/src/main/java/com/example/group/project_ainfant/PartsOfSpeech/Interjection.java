package com.example.group.project_ainfant.PartsOfSpeech;

/**
 * Created by eronj on 10/18/2016.
 */

public class Interjection extends Word {
    //used to determine subVObj value
    final private int GREETING = 0;
    final private int EXCLAMATION = 1;

    //if greeting or exclamation
    public static int type;

    public Interjection(String name_, int type_){
        //allows to also use the word constructor as defult(may need to change)
        super();
        //Constructor for Interjection
        this.name = name_;
        this.type = type_;

    }
}
