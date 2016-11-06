package com.example.group.project_ainfant.PartsOfSpeech;

/**
 * Created by eronj on 10/18/2016.
 */

public class Determiner extends Word{
    //used to determine howMany value
    final private int PLURAL = 0;
    final private int SINGULAR = 1;

    public static int howMany;

    //if initialized with no parameters
    public void Determiner() {
        howMany = SINGULAR;
    }

    public void Determiner(int actVPass){
        //need to fill in
    }
}
