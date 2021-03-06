package com.example.group.project_ainfant;

import com.example.group.project_ainfant.PartsOfSpeech.Adjective;
import com.example.group.project_ainfant.PartsOfSpeech.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alyx on 10/31/2016.
 */

/*note as the Look Ahead goes the the list of Words, create a new Node for each element in the
List and then attempts to shift reduce and build the tree up.
*/


/*The Look Ahead goes over the list of Words and attempts to shift-reduce the entire list the shift
 reduced Words then are traced again by the parser and shift-reduces again. This process keeps
 occurring until shift is able to reduce to a single node called sentence or fails to make a single
 shift during an iteration in which case the sentence is invalid*/

/*Root continuously adopts each node into itself until a shift reduce is possible*/
public class ParseTree {

    //NOTES FOR Robert:
    /*
    3. I changed the name of empty to empty children for clarity
    4. Also I am making a test for the ParseTree Function that we are going to make
       So we can have a clear input and output established based off of our conversation
    3. I also made a constructor for the parseTree
     */

    public Node parent = new Node(new Adjective("empty",0)) ;
    public List<Node> SRList = new ArrayList<Node>();
    public List<Node> Temp = new ArrayList<Node>();

    public ParseTree(List<Word> word_list){

        for (Word word:word_list) {
            Node word_node = new Node(word);
            // Node word_node = new Node(word_list.get(0));
            //Adjective shift_reduce_obj = new Adjective("shift_reduce_node",0);
            //Node srnode = new Node(shift_reduce_obj);
            //if (word_node == null) {
            SRList.add(word_node);
            // }
        }
    }
    /*
        //gets the node at the give ptr posiition
        public Node getNode(int ptr){
            Node node = SRList.get(ptr);
            return node;
        }
    */
    //as you Use the Look Ahead and go through the
    public void adoptToPtr(Node n){
        this.parent.addNode(n);
    }

    //use the ptr to shift reduce.
    public void shiftReduce(List<Node> childrenNodes,String cmplx_PoS){

        //had to create a dummy obj for shift reduce nodes
        Adjective shift_reduce_obj = new Adjective("shift_reduce_node",0);

        Node srnode = new Node(shift_reduce_obj);
        srnode.cmplx_PoS = cmplx_PoS;
        for(Node n: childrenNodes){
            srnode.addNode(n);
        }
        Temp.add(srnode);

    }
    public void noshift(Node n){
        Temp.add(n);
    }
    //sets the SRList and updates it to the temp list before it is cleared


    public void updateSRList(){
        this.SRList = new ArrayList<Node>(this.Temp);
        this.Temp.clear();
    }

    public boolean canAdopt(Node next_node){
        //get the current node from the node that has already
        //been adopted by the parent
        Node cur_node = parent.getChildren().get(0);
        SyntaxRules rules = new SyntaxRules();
        //returns the result of checkrules saying if the next
        //node can be adopted or not
        return rules.checkRules(cur_node,next_node);
    }

    //empties the Temp List
    public void clearTempList(){
        this.Temp.clear();
    }

    //Node class, child is a list of nodes and each node holds an Word
    public static class Node{

        private List<Node> child;
        private Word word_obj;
        private String cmplx_PoS;

        public Node(Word o){

            this.child = new ArrayList<Node>();
            this.word_obj = o;
            this.cmplx_PoS = o.getClass().getSimpleName();

        }
        public void addNode(Word o){
            this.child.add(new Node(o));
        }

        public void addNode(Node n){
            this.child.add(n);
        }

        public void emptyChildren(){
            this.child.clear();
        }
        public Word getNodeData(){
            return this.word_obj;

        }

        public List<Node> getChildren(){
            return this.child;
        }

        public String getPartOfSpeech(){
            return cmplx_PoS;
        }


    }


}