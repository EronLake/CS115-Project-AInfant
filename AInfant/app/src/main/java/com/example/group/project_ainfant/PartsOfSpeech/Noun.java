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

    public int type;
    public int propVImp;
    public int plurVSing;

<<<<<<< HEAD
    public Noun(String name_, int type_,int propVimp_, int plurVSing_){
=======
    //if initialized with no parameters
    public void noun() {
        type = THING;
        propVImp = IMPROPER;
    }

    public void noun(String name, int type, int propVimp){
>>>>>>> 14017ac8c725d3d9a667e3d4af7439dd845abc9d
        //need to fill in
        this.name = name_;
        this.type = type_;
        this.propVImp = propVimp_;
        this.plurVSing = plurVSing_;
    }

}
