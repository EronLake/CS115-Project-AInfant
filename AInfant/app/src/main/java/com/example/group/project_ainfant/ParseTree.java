package main.java.com.example.group.project_ainfant;

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

    private Node root;
    private List<Node> SRList;

    public ParseTree(){

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
        root.empty();
        root.addNode(sr);
        SRList.add(sr);

    }
    //gets the SRList
    public List<Node> getSRList(){
        return this.SRList;
    }
    //empties the SRList
    public void clearSRList(){
        this.SRList.clear();
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
        public void empty(){

            this.child.clear();

        }

    }

}

