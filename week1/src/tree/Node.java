package tree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class Node {
    private String name;
    private LinkedList<Node> children;
    private NodeType type;
    private int priority;
    public Node(NodeType type, String name, int priority){
        this.type = type;
        this.name = name;
        this.priority = priority;
        children = new LinkedList<>();
    }

    public LinkedList<Node> getChildren() {
        return children;
    }

    public LinkedList<Node> getAllChildren(LinkedList<Node> list) {
        list.add(this);
        for (int i = 0; i < this.children.size(); i++) {
            this.children.get(i).getAllChildren(list);
        }
        return list;
    }
    public String getName() {
        return name;
    }

    public NodeType getType(){
        return type;
    }

    public int getPriority() {
        return priority;
    }

    public void addChild(Node node) {
        if(this.getType().compareTo(node.getType()) < 0 ) {
            System.out.println("added " + node.getName() + " to "+ this.name);
            this.children.add(node);
        }
    }

    public static class AlphComparator implements Comparator<Node>{
        @Override
        public int compare(Node node, Node t1) {
            return node.getName().compareTo(t1.getName());
        }


            @Override
            public Comparator<Node> reversed () {
            return null;
        }

            @Override
            public Comparator<Node> thenComparing (Comparator < ? super Node > comparator){
            return null;
        }

            @Override
            public <U > Comparator < Node > thenComparing(Function < ? super Node, ? extends
            U > function, Comparator < ? super U > comparator){
            return null;
        }

            @Override
            public <U extends Comparable<? super U>>Comparator<Node> thenComparing (Function < ? super Node, ? extends
            U > function){
            return null;
        }

            @Override
            public Comparator<Node> thenComparingInt (ToIntFunction < ? super Node > toIntFunction){
            return null;
        }

            @Override
            public Comparator<Node> thenComparingLong (ToLongFunction < ? super Node > toLongFunction){
            return null;
        }

            @Override
            public Comparator<Node> thenComparingDouble (ToDoubleFunction < ? super Node > toDoubleFunction){
            return null;
        }

    }

    public static class PriorityComparator implements  Comparator<Node>{
        @Override
        public int compare(Node node, Node t1) {
            return node.getPriority() - t1.getPriority();
        }
    }
}

