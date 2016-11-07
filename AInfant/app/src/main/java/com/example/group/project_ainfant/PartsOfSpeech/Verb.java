package com.example.group.project_ainfant.PartsOfSpeech;

/**
 * Created by eronj on 10/18/2016.
 */

//holds fields relative to a verb
public class Verb extends Word{
    //used to determine type value
    final private int ACTIVE = 0;
    final private int PASSIVE = 1;

    public static int actVPass;

    public Verb(String name_, int actVPass_){
        //allows to also use the word constructor as defult(may need to change)
        //super();
        //Constructor for verb
        this.name = name_;
        this.actVPass = actVPass_;
    }

}
