package com.example.group.project_ainfant.PartsOfSpeech;

/**
 * Created by eronj on 11/14/2016.
 */

public class Conjunction extends Word{
    //used to determine type value
    final private int COORDINATING = 0;
    final private int SUBORDINATING = 1;

    final private int AND_OR_NOR = 2;
    final private int BUT_FOR_YET = 3;

    public static int cordVSub;
    public static int andVBut;

    public Conjunction(String name_, int cordVSub_, int andVBut_){

        //Constructor for verb
        this.name = name_;
        this.cordVSub = cordVSub_;
        this.andVBut = andVBut_;
    }
}
