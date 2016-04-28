import java.util.ArrayList;

/**
 * Created by Leonardo Linhares on 27/04/2016.
 */
public class NodeLeaf extends Node{

    ArrayList<Integer> dataEntry;
    NodeLeaf left;
    NodeLeaf right;

    public NodeLeaf() {
        children = new ArrayList<>(2*order+1);
        keys =  new ArrayList<>(2*order);
        dataEntry = new ArrayList<>();
        isLeaf = true;
    }
}
