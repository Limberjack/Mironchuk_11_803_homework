import tree.Node;
import tree.*;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Node russia, tataria, chelni, kazan;
        russia = new Node(NodeType.COUNTRY, "rossiya", 10);
        tataria = new Node(NodeType.REGION, "tataria", 9);
        kazan = new Node(NodeType.CITY, "kazan", 8);
        chelni = new Node(NodeType.CITY, "chelni", 7);
        Node moskva = new Node(NodeType.CITY, "moskva", 11);

        Tree tree = new Tree(russia);
        russia.addChild(tataria);
        russia.addChild(moskva);
        tataria.addChild(chelni);
        tataria.addChild(kazan);


        Iterator<Node> i1 = tree.getAlpIterator();
        Iterator<Node> i2 = tree.getPriorityIterator();
        Iterator<Node> i3 = tree.getIteratorBFS();

        while(i1.hasNext()){
            System.out.println(1);
            System.out.print(i1.next().getName() + " ");
        }
        System.out.println();
        while(i2.hasNext()){
            System.out.println(2);
            System.out.print(i2.next().getName() + " ");
        }

        System.out.println();
        while(i3.hasNext()){
            System.out.println(3);
            System.out.print(i3.next().getName() + " ");
        }


    }
}
