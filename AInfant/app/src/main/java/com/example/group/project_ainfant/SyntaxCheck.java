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

    SyntaxCheck(List<Word> w){

        ParseTree p = new ParseTree(w);

    }

    public boolean ListSweep(){

        boolean if_shift_reduced = false;

        for(int sweep_ptr = 0; sweep_ptr < p.SRList.size(); sweep_ptr++ ){
        // gets lookahead
        ParseTree.Node next_node = p.getNode(sweep_ptr);

        //check if you can shift reduce or not

            //call boolean canAdopt(next_node)
                // canAdopt looks at parent node's child(current node)
                // to determine if new_ode can be adopted

                //if it can shift reduce and change if_shift_reduced = true

                //else continue;
            //check rules
        }

        return true;
    }




}
