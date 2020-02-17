package tree;

import iterator.AlphIterator;
import iterator.PriorityIterator;
import iterator.IteratorBFS;

import java.util.LinkedList;

public class Tree {
    private Node root;
    public Tree(Node root){
        this.root = root;
    }

    public Node getRoot(){
        return root;
    }

    public AlphIterator getAlpIterator(){
        LinkedList<Node> list = new LinkedList<>();
        return new AlphIterator(root.getAllChildren(list));
    }

    public PriorityIterator getPriorityIterator(){
        LinkedList<Node> list = new LinkedList<>();
        return new PriorityIterator(root.getAllChildren(list));
    }

    public IteratorBFS getIteratorBFS(){
        return new IteratorBFS(root);
    }
}
