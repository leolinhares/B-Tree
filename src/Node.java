import java.util.ArrayList;

/**
 * Created by leolinhares on 02/07/2016.
 */
public class Node {

    Node left;
    Node middle;
    Node right;
    int keyLeft;
    int keyRight;
    boolean isLeaf = false;
    ArrayList<DataItem> listOfDataItems = new ArrayList<>();

    public Node() {

    }
}
