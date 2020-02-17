package iterator;

import tree.Node;

import java.util.Iterator;
import java.util.LinkedList;

public class PriorityIterator implements Iterator<Node> {
    private Node list[];
    private int counter;

    public PriorityIterator(LinkedList<Node> list){
        this.list = new Node[list.size()];
        for (int j = 0; j < this.list.length; j++) {
            this.list[j] = list.get(j);
        }
        counter = 0;
        sort();
    }
    private void sort(){
        for (int i = 0; i < list.length; i++) {
            for (int j = i; j < list.length; j++) {
                if(list[i].getPriority() < list[j].getPriority())
                    swap(i, j);
            }
        }
    }

    private void swap(int i, int j){
        Node tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
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
