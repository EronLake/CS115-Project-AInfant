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

    SyntaxCheck(List<Object> w){

        ParseTree p = new ParseTree(w);

    }

    //Need to make test for both function.
    public boolean isValidSentence(){

        while(ListSweep()){

        }
        if(p.SRList.get(0).getNodeData().equals("Sentence")){
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
        p.adoptToPtr(curr_node);

            ParseTree.Node next_node = p.getNode(sweep_ptr+1);
            if(sr.checkRules(curr_node,next_node)){
                p.adoptToPtr(next_node);
                p.shiftReduce(p.parent.getChildren(),sr.getShiftReduceName(curr_node,next_node));
                if_shift_reduced = true;
                sweep_ptr++;
            }
            else{
                p.noshift(curr_node);
            }


        //check if you can shift reduce or not

            //call boolean canAdopt(next_node)
                // canAdopt looks at parent node's child(current node)
                // to determine if new_ode can be adopted

                //if it can shift reduce and change if_shift_reduced = true

                //else continue;
            //check rules
        }
        p.updateSRList();
        return if_shift_reduced;
    }


}
