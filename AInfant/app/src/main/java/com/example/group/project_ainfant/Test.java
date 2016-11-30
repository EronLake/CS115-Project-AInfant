package com.example.group.project_ainfant;

import android.util.Log;

import com.example.group.project_ainfant.PartsOfSpeech.Adjective;
import com.example.group.project_ainfant.PartsOfSpeech.Adverb;
import com.example.group.project_ainfant.PartsOfSpeech.Conjunction;
import com.example.group.project_ainfant.PartsOfSpeech.Determiner;
import com.example.group.project_ainfant.PartsOfSpeech.Noun;
import com.example.group.project_ainfant.PartsOfSpeech.Preposition;
import com.example.group.project_ainfant.PartsOfSpeech.Pronoun;
import com.example.group.project_ainfant.PartsOfSpeech.Verb;
import com.example.group.project_ainfant.PartsOfSpeech.Word;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by eronj on 11/6/2016.
 */

public class Test {

    public Test(){}

    private static final String TAG = Test.class.getSimpleName();


    public void runUnitTests(){
        //runs all the unit tests
        Test testRunner = new Test();
        testRunner.constructObjectTest();
        testRunner.checkRulesTest();
        testRunner.getShiftReduceNameTest();
        testRunner.isValidSentenceTest();
        testRunner.isValidSentenceTest1();
        testRunner.isValidSentenceTest2();
        testRunner.isValidSentenceTest3();
        testRunner.isValidSentenceTest4();
        testRunner.isValidSentenceTest5();
    }



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

    //test method for the constructObject function
    public boolean isValidSentenceTest() {

        //create our word variables
        Noun test =  new Noun("I",0,3,5);
        Verb test2 =  new Verb("ran",0);
        Preposition test3 =  new Preposition("to",0);
        Determiner test4 =  new Determiner("the",0);
        Noun test5 =  new Noun("Store",0,3,5);

        //add them to our input list
        List<Word> input_list = new ArrayList<Word>();
        input_list.add(test);
        input_list.add(test2);
        input_list.add(test3);
        input_list.add(test4);
        input_list.add(test5);

        //Log.d(TAG, input_list.get());
        //create syntax checker object with input list inside
        SyntaxCheck syntax_checker = new SyntaxCheck(input_list);
        Log.d(TAG,syntax_checker.p.SRList.size() +" ");

        Log.d(TAG, "size before isValid: " + syntax_checker.p.SRList.size());
        //calls the isValidSentence Function
        boolean results = syntax_checker.isValidSentence();

        Log.d(TAG, "size after isValid: " + syntax_checker.p.SRList.size());
        //checks output for desired results
        if (results == false){
            Log.d(TAG, "isValidSentenceTest() returned " + results);
            for (int i = 0; i < syntax_checker.p.SRList.size();i ++ ){
                Log.d(TAG,syntax_checker.p.SRList.get(0).getPartOfSpeech() +" ");
                //Log.d(TAG,syntax_checker.p.SRList.size() +" ");
            }
            return false;
        }else {
            Log.d(TAG, "isValidSentenceTest() returned " + results);
            //Log.d(TAG, toString(results));
            for (int i = 0; i < syntax_checker.p.SRList.size();i ++ ){
                Log.d(TAG,syntax_checker.p.SRList.get(i).getPartOfSpeech() +" ");
                //Log.d(TAG,syntax_checker.p.SRList.size() +" ");
            }
            return true;
        }
    }

    public boolean isValidSentenceTest1() {

        //create our word variables
        Noun test =  new Noun("I",0,3,5);
        Verb test2 =  new Verb("like",0);
        Pronoun test5 =  new Pronoun("her",0,3,5);

        //add them to our input list
        List<Word> input_list = new ArrayList<Word>();
        input_list.add(test);
        input_list.add(test2);
        input_list.add(test5);

        //Log.d(TAG, input_list.get());
        //create syntax checker object with input list inside
        SyntaxCheck syntax_checker = new SyntaxCheck(input_list);
        Log.d(TAG,syntax_checker.p.SRList.size() +" ");

        Log.d(TAG,"before isValidSentenceTest1: " + syntax_checker.p.SRList.size());
        //calls the isValidSentence Function
        boolean results = syntax_checker.isValidSentence();
        Log.d(TAG,"after isValidSentenceTest1: " + syntax_checker.p.SRList.size());


        //checks output for desired results
        if (results == false){
            Log.d(TAG, "isValidSentenceTest1() returned " + results);
            for (int i = 0; i < syntax_checker.p.SRList.size();i ++ ){
                Log.d(TAG,syntax_checker.p.SRList.get(0).getPartOfSpeech() +" ");
                //Log.d(TAG,syntax_checker.p.SRList.size() +" ");
            }
            return false;
        }else {
            Log.d(TAG, "isValidSentenceTest1() returned " + results);
            //Log.d(TAG, toString(results));
            for (int i = 0; i < syntax_checker.p.SRList.size();i ++ ){
                Log.d(TAG,syntax_checker.p.SRList.get(i).getPartOfSpeech() +" ");
                //Log.d(TAG,syntax_checker.p.SRList.size() +" ");
            }
            return true;
        }
    }
    public boolean isValidSentenceTest2() {

        //create our word variables
        Noun test =  new Noun("I",0,3,5);
        Verb test1 = new Verb("am",0);
        Adverb test2 = new Adverb("very",0);
        Adjective test3 = new Adjective("hungry",0);

        //add them to our input list
        List<Word> input_list = new ArrayList<Word>();
        input_list.add(test);
        input_list.add(test1);
        input_list.add(test2);
        input_list.add(test3);

        //Log.d(TAG, input_list.get());
        //create syntax checker object with input list inside
        SyntaxCheck syntax_checker = new SyntaxCheck(input_list);
        Log.d(TAG,syntax_checker.p.SRList.size() +" ");


        Log.d(TAG,"before isValidSentenceTest2: " + syntax_checker.p.SRList.size());
        //calls the isValidSentence Function
        boolean results = syntax_checker.isValidSentence();
        Log.d(TAG,"after isValidSentenceTest2: " + syntax_checker.p.SRList.size());


        //checks output for desired results
        if (results == false){
            Log.d(TAG, "isValidSentenceTest2() returned " + results);
            for (int i = 0; i < syntax_checker.p.SRList.size();i ++ ){
                Log.d(TAG,syntax_checker.p.SRList.get(0).getPartOfSpeech() +" ");
                //Log.d(TAG,syntax_checker.p.SRList.size() +" ");
            }
            return false;
        }else {
            Log.d(TAG, "isValidSentenceTest2() returned " + results);
            //Log.d(TAG, toString(results));
            for (int i = 0; i < syntax_checker.p.SRList.size();i ++ ){
                Log.d(TAG,syntax_checker.p.SRList.get(i).getPartOfSpeech() +" ");
                //Log.d(TAG,syntax_checker.p.SRList.size() +" ");
            }
            return true;
        }
    }
    public boolean isValidSentenceTest3() {

        //create our word variables
        //I went to the park with my friends
        Noun test =  new Noun("I",0,3,5);
        Verb test2 =  new Verb("went",0);
        Preposition test3 = new Preposition("to",0);
        Determiner test4 = new Determiner("the",0);
        Noun test5 = new Noun("park", 0,0,0);
        Preposition test6 = new Preposition("with",0);
        Determiner test7 = new Determiner("my",0);
        Noun test8 = new Noun("friends",0,0,0);

        //add them to our input list
        List<Word> input_list = new ArrayList<Word>();
        input_list.add(test);
        input_list.add(test2);
        input_list.add(test3);
        input_list.add(test4);
        input_list.add(test5);
        input_list.add(test6);
        input_list.add(test7);
        input_list.add(test8);

        //Log.d(TAG, input_list.get());
        //create syntax checker object with input list inside
        SyntaxCheck syntax_checker = new SyntaxCheck(input_list);
        Log.d(TAG,syntax_checker.p.SRList.size() +" ");


        Log.d(TAG,"before isValidSentenceTest3: " + syntax_checker.p.SRList.size());
        //calls the isValidSentence Function
        boolean results = syntax_checker.isValidSentence();
        Log.d(TAG,"after isValidSentenceTest3: " + syntax_checker.p.SRList.size());

        //checks output for desired results
        if (results == false){
            Log.d(TAG, "isValidSentenceTest3() returned " + results);
            for (int i = 0; i < syntax_checker.p.SRList.size();i ++ ){
                Log.d(TAG,syntax_checker.p.SRList.get(0).getPartOfSpeech() +" ");
                //Log.d(TAG,syntax_checker.p.SRList.size() +" ");
            }
            return false;
        }else {
            Log.d(TAG, "isValidSentenceTest3() returned " + results);
            //Log.d(TAG, toString(results));
            for (int i = 0; i < syntax_checker.p.SRList.size();i ++ ){
                Log.d(TAG,syntax_checker.p.SRList.get(i).getPartOfSpeech() +" ");
                //Log.d(TAG,syntax_checker.p.SRList.size() +" ");
            }
            return true;
        }
    }
    public boolean isValidSentenceTest4() {

        //create our word variables
        //we arrived early to the party and waited
        Noun test =  new Noun("She",0,3,5);
        Verb test2 =  new Verb("arrived",0);
        Adjective test3 = new Adjective("early",0);
        Preposition test4 = new Preposition("to",0);
        Determiner test5 = new Determiner("the",0);
        Noun test6 = new Noun("party",0,0,0);
        Conjunction test7 = new Conjunction("and",0,0);
        Verb test8 = new Verb("waited",0);

        //add them to our input list
        List<Word> input_list = new ArrayList<Word>();
        input_list.add(test);
        input_list.add(test2);
        input_list.add(test3);
        input_list.add(test4);
        input_list.add(test5);
        input_list.add(test6);
        input_list.add(test7);
        input_list.add(test8);

        //Log.d(TAG, input_list.get());
        //create syntax checker object with input list inside
        SyntaxCheck syntax_checker = new SyntaxCheck(input_list);
        Log.d(TAG,syntax_checker.p.SRList.size() +" ");


        Log.d(TAG,"before isValidSentenceTest4: " + syntax_checker.p.SRList.size());
        //calls the isValidSentence Function
        boolean results = syntax_checker.isValidSentence();
        Log.d(TAG,"after isValidSentenceTest4: " + syntax_checker.p.SRList.size());


        //checks output for desired results
        if (results == false){
            Log.d(TAG, "isValidSentenceTest4() returned " + results);
            for (int i = 0; i < syntax_checker.p.SRList.size();i ++ ){
                Log.d(TAG,syntax_checker.p.SRList.get(0).getPartOfSpeech() +" ");
                //Log.d(TAG,syntax_checker.p.SRList.size() +" ");
            }
            return false;
        }else {
            Log.d(TAG, "isValidSentenceTest4() returned " + results);
            //Log.d(TAG, toString(results));
            for (int i = 0; i < syntax_checker.p.SRList.size();i ++ ){
                Log.d(TAG,syntax_checker.p.SRList.get(i).getPartOfSpeech() +" ");
                //Log.d(TAG,syntax_checker.p.SRList.size() +" ");
            }
            return true;
        }
    }
    public boolean isValidSentenceTest5() {

        //create our word variables
        //we arrived early to the party and waited

        Determiner test = new Determiner("the",0);
        Adjective test1 = new Adjective("new",0);
        Noun test2 = new Noun("update",0,0,0);
        Verb test3 = new Verb("will", 0);
        Verb test4 = new Verb("be",0);
        Verb test5 = new Verb("delayed",0);

        //add them to our input list
        List<Word> input_list = new ArrayList<Word>();
        input_list.add(test);
        input_list.add(test1);
        input_list.add(test2);
        input_list.add(test3);
        input_list.add(test4);
        input_list.add(test5);

        //Log.d(TAG, input_list.get());
        //create syntax checker object with input list inside
        SyntaxCheck syntax_checker = new SyntaxCheck(input_list);
        Log.d(TAG,syntax_checker.p.SRList.size() +" ");


        Log.d(TAG,"before isValidSentenceTest5: " + syntax_checker.p.SRList.size());
        //calls the isValidSentence Function
        boolean results = syntax_checker.isValidSentence();
        Log.d(TAG,"after isValidSentenceTest5: " + syntax_checker.p.SRList.size());


        //checks output for desired results
        if (results == false){
            Log.d(TAG, "isValidSentenceTest4() returned " + results);
            for (int i = 0; i < syntax_checker.p.SRList.size();i ++ ){
                Log.d(TAG,syntax_checker.p.SRList.get(0).getPartOfSpeech() +" ");
                //Log.d(TAG,syntax_checker.p.SRList.size() +" ");
            }
            return false;
        }else {
            Log.d(TAG, "isValidSentenceTest4() returned " + results);
            //Log.d(TAG, toString(results));
            for (int i = 0; i < syntax_checker.p.SRList.size();i ++ ){
                Log.d(TAG,syntax_checker.p.SRList.get(i).getPartOfSpeech() +" ");
                //Log.d(TAG,syntax_checker.p.SRList.size() +" ");
            }
            return true;
        }
    }

}

