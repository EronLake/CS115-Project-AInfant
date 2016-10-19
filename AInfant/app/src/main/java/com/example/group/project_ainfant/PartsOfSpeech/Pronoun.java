package com.example.group.project_ainfant.PartsOfSpeech;

/**
 * Created by eronj on 10/18/2016.
 */

public class Pronoun {
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
    int subVObj;
    int gender;
    //singular or plural
    int howMany;


    //if initialized with no parameters
    public void Pronoun() {
        subVObj = SUBJECT;
        gender = OBJECT;
        howMany = SINGULAR;
    }

    public void Pronoun(int subVObj,int gender,int howMany){
        //need to fill in
    }

}
