package com.example.group.project_ainfant.PartsOfSpeech;

/**
 * Created by eronj on 10/18/2016.
 */

public class Determiner extends Word {
    //used to determine howMany value
    final private int PLURAL = 0;
    final private int SINGULAR = 1;

    public static int howMany;

    public Determiner(String name_, int howMany_){
        //allows to also use the word constructor as defult(may need to change)
        super();
        //Constructor for Determiner
        this.name = name_;
        this.howMany = howMany_;
    }
}
