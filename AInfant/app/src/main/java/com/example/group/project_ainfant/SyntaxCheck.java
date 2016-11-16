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

        SyntaxRules sr = new SyntaxRules();

        boolean if_shift_reduced = false;

        for(int sweep_ptr = 0; sweep_ptr < p.SRList.size(); sweep_ptr++ ){
        // gets lookahead
        ParseTree.Node curr_node = p.getNode(sweep_ptr);
        p.adoptToPtr(curr_node);


        for(int ptrNxt = sweep_ptr +1;ptrNxt < p.SRList.size(); ptrNxt++){
            ParseTree.Node next_node = p.getNode(ptrNxt);
            if(sr.checkRules(curr_node,next_node)){
                p.adoptToPtr(next_node);
            }
            else{
                if(p.parent.getChildren().size() == 1)
                {
                     p.shiftReduce(p.parent.getChildren(),p.);
                }
            }
        }

        //check if you can shift reduce or not

            //call boolean canAdopt(next_node)
                // canAdopt looks at parent node's child(current node)
                // to determine if new_ode can be adopted

                //if it can shift reduce and change if_shift_reduced = true

                //else continue;
            //check rules
        }

        return if_shift_reduced;
    }




}
