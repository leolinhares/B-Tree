import java.util.ArrayList;

/**
 * Created by Leonardo Linhares on 27/04/2016.
 */
public class NodeIndex extends Node{
    public NodeIndex() {
        children = new ArrayList<>(2*order+1);
        keys =  new ArrayList<>(2*order);
    }
}
