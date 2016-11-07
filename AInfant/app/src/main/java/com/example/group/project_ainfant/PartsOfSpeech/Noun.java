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
    final private int PROPER = 2;
    final private int IMPROPER = 3;
    //used to determine type PlurVSing value
    final private int PLURAL = 2;
    final private int SINGULAR = 3;

    public static int type;
    public static int propVImp;
    //singular or plural
    public static int howMany;

    public Noun(String name_, int type_,int propVimp_, int howMany_){
        //allows to also use the word constructor as defult(may need to change)
        super();
        //Constructor for Noun
        this.name = name_;
        this.type = type_;
        this.propVImp = propVimp_;
        this.howMany = howMany_;

    }

}
