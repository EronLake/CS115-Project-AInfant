package com.example.group.project_ainfant;

import android.util.Log;

import com.example.group.project_ainfant.PartsOfSpeech.Adjective;
import com.example.group.project_ainfant.PartsOfSpeech.Noun;
import com.example.group.project_ainfant.PartsOfSpeech.Word;

import java.util.Hashtable;
import java.util.List;

/**
 * Created by eronj on 11/6/2016.
 */

public class Test {

    public Test(){}

    private static final String TAG = Test.class.getSimpleName();
    //test method for the constructObject function
    public boolean constructObjectTest() {

        //Creates method input
        String word = "dog";
        String PoS = "Noun";
        Hashtable<String, Integer> Tags = new Hashtable<String,Integer>(){{
            put("type", 0);
            put("propVImp", 3);
            put("singVPlur", 5);
        }};

        Word new_Word = new Word();
        //calls the construct object method
        new_Word = new_Word.constructObject(word, PoS, Tags);
        //checks output for desired results
        if (new_Word == null){
            Log.d(TAG, "constructObjectTest() returned false");
            return false;
        }else {
            Log.d(TAG, "constructObjectTest() returned true");
            Log.d(TAG, new_Word.name);
            return true;
        }
    }


    //test method for the constructObject function
    public boolean parseTreeTest() {
    /*
    public ParseTree(List<Word> word_list){
        for (Word word:word_list) {
            main.java.com.example.group.project_ainfant.ParseTree.Node word_node = newNode(word);
            SRList.add(word_node);
        }

    }
    */
        List<Word> word_list;
        return true;
    }

    //test method for the constructObject function
    public boolean checkRulesTest() {
        //Creates method input
        Noun test =  new Noun("test",0,3,5);

        ParseTree.Node cur_node = new ParseTree.Node(test);
        ParseTree.Node next_node = new ParseTree.Node(test);


        SyntaxRules rules =  new SyntaxRules();
        //calls the construct object method
        boolean results = rules.checkRules(cur_node,next_node);
        //checks output for desired results
        if (results == false){
            Log.d(TAG, "checkRulesTest() returned false");
            Log.d(TAG, "cur_node: " + cur_node.getPartOfSpeech() + ", " +
                    "next_node: " + next_node.getPartOfSpeech());
            return false;
        }else {
            Log.d(TAG, "checkRulesTest() returned true");
            //Log.d(TAG, toString(results));
            return true;
        }
    }

    //test method for the constructObject function
    public boolean getShiftReduceNameTest() {
        //Creates method input
        Noun test =  new Noun("test",0,3,5);
        Adjective test2 =  new Adjective("test",0);

        ParseTree.Node cur_node = new ParseTree.Node(test2);
        ParseTree.Node next_node = new ParseTree.Node(test);


        SyntaxRules rules =  new SyntaxRules();
        //calls the construct object method
        String results = rules.getShiftReduceName(cur_node,next_node);
        //checks output for desired results
        if (results == "Compound_Noun_Front"){
            Log.d(TAG, "getShiftReduceNameTest() returned " + results);
            Log.d(TAG, "cur_node: " + cur_node.getPartOfSpeech() + ", " +
                    "next_node: " + next_node.getPartOfSpeech());
            return false;
        }else {
            Log.d(TAG, "getShiftReduceNameTest() returned " + results);
            //Log.d(TAG, toString(results));
            return true;
        }
    }
}
