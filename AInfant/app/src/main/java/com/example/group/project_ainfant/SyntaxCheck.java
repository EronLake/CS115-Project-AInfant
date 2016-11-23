package com.example.group.project_ainfant;


import android.util.Log;

import com.example.group.project_ainfant.PartsOfSpeech.Word;

import java.util.List;

/**
 * Created by Robert on 11/6/2016.
 */
//checks the grammar of the sentence and creates a parse tree for that sentence
    //testing
public class SyntaxCheck {

    ParseTree p;
    private static final String TAG = Test.class.getSimpleName();
    SyntaxCheck(List<Word> w){

        this.p = new ParseTree(w);

    }

    //Need to make test for both function.
    public boolean isValidSentence(){
        int pass = 1;
        while(ListSweep()){
            Log.d(TAG, "ListSweep Pass: " + pass);
            pass++;
        }
        if(p.SRList.size() == 2){
            return true;
        }
        else{

            return false;

        }

    }

    public boolean ListSweep(){

        SyntaxRules sr = new SyntaxRules();

        boolean if_shift_reduced = false;

        for(int sweep_ptr = 0; sweep_ptr < p.SRList.size(); sweep_ptr++ ){
            // gets lookahead
            ParseTree.Node curr_node = p.getNode(sweep_ptr);
            //automatically adopt the first node
            p.adoptToPtr(curr_node);
            //get the second node in the list
            ParseTree.Node next_node = p.getNode(sweep_ptr+1);
            //check if you can shift reduce using the checkrules function
            if(sr.checkRules(curr_node,next_node)){
                //if can adopt then:
                //adopt to parent node:
                p.adoptToPtr(next_node);
                //shipd reduce using :
                p.shiftReduce(p.parent.getChildren(),sr.getShiftReduceName(curr_node,next_node));
                if_shift_reduced = true;
                sweep_ptr++;
            }
            else{
                p.noshift(curr_node);
            }

        }
        p.updateSRList();
        return if_shift_reduced;
    }


}
