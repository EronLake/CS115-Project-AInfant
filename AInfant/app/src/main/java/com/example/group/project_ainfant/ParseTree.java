package main.java.com.example.group.project_ainfant;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alyx on 10/31/2016.
 */

public class ParseTree {



    ParseTree(Object o){

        Node root = new Node(o);

    }
    public void AddChild(Node n){

       // addNode(n);

    }

}
class Node{

    private List<Node> child = null;
    private Object obj;

    public Node(Object o){

        this.child = new ArrayList<>();
        this.obj = o;

    }
    public void addNode(Node node){

        this.child.add(node);

    }

}