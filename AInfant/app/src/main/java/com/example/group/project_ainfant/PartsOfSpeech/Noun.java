package com.example.group.project_ainfant.PartsOfSpeech;

/**
 * Created by eronj on 10/18/2016.
 */

//holds fields relative to a noun
public class Noun extends Word {

    //used to determine type value
    final private int THING = 0;
    final private int PERSON = 1;
    final private int PLACE = 2;
    //used to determine type propVImp value
    final private int PROPER = 3;
    final private int IMPROPER = 4;
    //used to determine type PlurVSing value
    final private int PLURAL = 5;
    final private int SINGULAR = 6;

    public static int type;
    public static int propVImp;
    //singular or plural
    public static int singVPlur;

    public Noun(String name_, int type_,int propVimp_, int singVPlur_){

        //Constructor for Noun
        this.name = name_;
        this.type = type_;
        this.propVImp = propVimp_;
        this.singVPlur = singVPlur_;

    }

}
