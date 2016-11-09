package main.java.com.example.group.project_ainfant;

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
    1. THe root doesn't appear to be functioning as the root based off of our conversation
       and what the code looks like it is doing, so we should rename it to current_pointer
       or something like that

    2. I added the Temp List to the parseTree structure
    3. I changed the name of empty to empty children for clarity
    4. Also I am making a test for the ParseTree Function that we are going to make
       So we can have a clear input and output established based off of our conversation
     */

    private Node root;
    private List<Node> SRList;
    private List<Node> TempList;

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
    //root adopts an object as its child node
    public void adoptToRoot(Object o){
        this.root.addNode(o);
    }
    //takes the root and object to shift reduce to and makes the SR object take the place of the
    //root node and make the root the parent of the new SR node and then empties the root and adds
    //the SR node to the tree
    public void shiftReduce(Object o){

        Node sr = newNode(o);
        sr = root;
        root.emptyChildren();
        root.addNode(sr);
        SRList.add(sr);

    }

    //gets the SRList
    public List<Node> getSRList(){
        return this.SRList;
    }

    //gets the Temp List
    public List<Node> geTempList(){
        return this.TempList;
    }



    //empties the SRList
    public void clearSRList(){
        this.SRList.clear();
    }

    //empties the Temp List
    public void clearTempList(){
        this.TempList.clear();
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

        public void emptyChildren(){

            this.child.clear();

        }

    }

}

