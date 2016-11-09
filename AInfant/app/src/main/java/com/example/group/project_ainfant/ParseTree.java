package com.example.group.project_ainfant;

import com.example.group.project_ainfant.PartsOfSpeech.Word;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alyx on 10/31/2016.
 */

/*note as the Look Ahead goes the the list of objects, create a new Node for each element in the
List and then attempts to shift reduce and build the tree up.
*/


/*The Look Ahead goes over the list of objects and attempts to shift-reduce the entire list the shift
 reduced objects then are traced again by the parser and shift-reduces again. This process keeps
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

    private Node parent;
    public List<Node> SRList;
    public List<Node> Temp;

    public ParseTree(List<Word> word_list){
        for (Word word:word_list) {
            Node word_node = newNode(word);
            SRList.add(word_node);
        }
    }

    //creates a node from an object
    public Node newNode(Object o){
        Node n = new Node(o);
        return n;
    }
    //as you Use the Look Ahead and go through the
    public void adoptToPtr(Node n){
        this.parent.addNode(n);
    }

    //use the ptr to shift reduce.
    public void shiftReduce(List<Node> nds,Node node){

        Node srnode = newNode(node.getNodeDate());
        for(Node n: nds){
            srnode.addNode(n);
        }
        Temp.add(srnode);

    }

    //empties the SRList
    public void clearSRList() {
        this.SRList.clear();
    }

    //sets the SRList and updates it to the temp list before it is cleared
    public void updateSRList(){
        this.SRList = this.Temp;

    }

    //empties the Temp List
    public void clearTempList(){
        this.Temp.clear();
    }

    //Node class, child is a list of nodes and each node holds an object
    private static class Node{

        private List<Node> child;
        private Object obj;

        private Node(Object o){

            this.child = new ArrayList<Node>();
            this.obj = o;

        }
        public void addNode(Object o){

            this.child.add(new Node(o));

        }

        public void addNode(Node n){
            this.child.add(n);
        }

        public void emptyChildren(){
            this.child.clear();
        }
        public Object getNodeDate(){

            return this.obj;

        }

    }

}

