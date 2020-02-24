package interpretator;

import tree.NodeType;
import tree.Tree;

public class Interp {
    private Tree tree;

    public Interp(Tree tree){
        this.tree = tree;
    }

    public void act(String arg){
        if(arg.contains("return children")){
            arg = arg.substring(15)
        }
    }

    private void outputNode(NodeType type, String name)
}
