package com.example.group.project_ainfant.PartsOfSpeech;

/**
 * Created by eronj on 10/18/2016.
 */

public class Pronoun extends Word{
    //used to determine subVObj value
    final private int SUBJECT = 0;
    final private int OBJECT = 1;

    //used to determine gender value
    final private int MALE = 2;
    final private int FEMALE = 3;
    final private int OTHER = 4;

    //used to determine howMany value
    final private int PLURAL = 5;
    final private int SINGULAR = 6;

    //subject or object
    public static int subVObj;
    public static int gender;
    //singular or plural
    int howMany;

    public Pronoun(String name_, int subVObj_, int gender_, int howMany_){
        //allows to also use the word constructor as defult(may need to change)
        super();
        //Constructor for Pronoun
        this.name = name_;
        this.subVObj = subVObj_;
        this.gender = gender_;
        this.howMany = howMany_;
    }

}
