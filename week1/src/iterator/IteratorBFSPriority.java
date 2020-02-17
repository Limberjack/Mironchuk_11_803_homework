package iterator;

import tree.Node;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratorBFSPriority implements Iterator<Node>{

    private LinkedList<Node> list;
    private Iterator<Node> iterator;

    public IteratorBFSPriority(Node root){
        LinkedList<LinkedList<Node>> tree = new LinkedList<>();
        tree.add(new LinkedList<>());
        tree.getFirst().add(root);
        LinkedList<Node> tmp = root.getChildren();
        LinkedList<Node> tmp1;
        boolean flag = true;
        int level = 1;
        tree.add(tmp);

        while(flag){
            flag = false;
            level++;
            tmp = tree.getLast();                                //we take the last layer of "tree"
            for (int i = 0; i < tmp.size(); i++) {
                tmp1 = tmp.get(i).getChildren();
                if(tmp1.size() != 0){                            //if child has children we add a new layer to "tree"
                    flag = true;
                    if(level == tree.size())
                        tree.add(new LinkedList<>());            //if there is no available level on "tree", we add a new one
                    tree.getLast().addAll(tmp1);
                }
            }
        }

        list = new LinkedList<>();
        for (int i = 0; i < level; i++) {
            Node[] supportArray = (Node[])tree.get(i).toArray();
            for (int j = 0; j < supportArray.length; j++) {
                list.add(supportArray[j]);
            }
        }

        iterator = list.iterator();
    }

    private void sort(Node[] list){
        for (int i = 0; i < list.length; i++) {
            for (int j = i; j < list.length; j++) {
                if(list[i].getPriority() < list[j].getPriority())
                    swap(list ,i, j);
            }
        }
    }

    private void swap(Node[] list, int i, int j){
        Node tmp = list[i];
        list[i] = list[j];
        list[j] = tmp;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Node next() {
        return iterator.next();
    }
}
