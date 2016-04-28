import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * Created by Leonardo Linhares on 27/04/2016.
 */
public class NodeLeaf extends Node{

    // mapeando <k, lista de rids>
    HashMap<Integer, ArrayList<Integer>> dataEntry;
    NodeLeaf left;
    NodeLeaf right;

    public NodeLeaf() {
        dataEntry = new HashMap<>();
        children = new ArrayList<>(2*order+1);
        isLeaf = true;
    }
}
