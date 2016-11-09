package com.example.group.project_ainfant;


import com.example.group.project_ainfant.PartsOfSpeech.Word;

import java.util.List;

/**
 * Created by Robert on 11/6/2016.
 */
//checks the grammar of the sentence and creates a parse tree for that sentence
    //testing
public class SyntaxCheck {

    ParseTree p;
    int lookahead_ptr;

    SyntaxCheck(List<Word> w){
        
        ParseTree p = new ParseTree(w);

    }

    public boolean lookAhead(){

        p.SRList.get(lookahead_ptr);
        return true;
    }




}
