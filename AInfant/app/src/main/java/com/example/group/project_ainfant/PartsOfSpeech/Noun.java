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

    int type;
    int propVImp;

    //if initialized with no parameters
    public void noun() {
        type = THING;
        propVImp = IMPROPER;
    }

    public void noun(String name, int type,int propVimp){
        //need to fill in
    }

}
