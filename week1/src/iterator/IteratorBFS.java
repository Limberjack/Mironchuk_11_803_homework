package iterator;

import tree.Node;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratorBFS implements Iterator<Node> {

    private LinkedList<Node> list;
    private Iterator<Node> iterator;

    public IteratorBFS(Node root){
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
        for (int i = 0; i < level; i++)
            list.addAll(tree.get(i));

        iterator = list.iterator();
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
