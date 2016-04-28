import java.util.ArrayList;

/**
 * Created by Leonardo Linhares on 27/04/2016.
 */
public abstract class Node {

    int order;
    ArrayList<Node> children;
    ArrayList<Integer> keys;
    boolean isLeaf;
}
