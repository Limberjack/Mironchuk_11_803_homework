package iterator;

import tree.Node;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratorDFS implements Iterator<Node> {
    private Node list[];
    private int counter;

    public IteratorDFS(LinkedList<Node> list){
        this.list = new Node[list.size()];
        for (int j = 0; j < this.list.length; j++) {
            this.list[j] = list.get(j);
        }
        counter = 0;
    }

    @Override
    public boolean hasNext() {
        return counter < list.length;
    }

    @Override
    public Node next() {
        if(counter == list.length)
            return null;
        counter++;
        return list[counter - 1];
    }
}
