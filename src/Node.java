import java.util.ArrayList;

/**
 * Created by leolinhares on 02/07/2016.
 */
public class Node {

    private int id;
    private Node left;
    private Node middle;
    private Node right;
    private int keyLeft;
    private int keyRight;
    private boolean isLeaf;
    private ArrayList<DataItem> leftDataItens = new ArrayList<>();
    private ArrayList<DataItem> rightDataItens = new ArrayList<>();

    public Node() {
        this.keyLeft = -1;
        this.keyRight = -1;
        this.isLeaf = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getMiddle() {
        return middle;
    }

    public void setMiddle(Node middle) {
        this.middle = middle;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getKeyLeft() {
        return keyLeft;
    }

    public void setKeyLeft(int keyLeft) {
        this.keyLeft = keyLeft;
    }

    public int getKeyRight() {
        return keyRight;
    }

    public void setKeyRight(int keyRight) {
        this.keyRight = keyRight;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setLeaf(boolean leaf) {
        isLeaf = leaf;
    }

    public ArrayList<DataItem> getLeftDataItens() {
        return leftDataItens;
    }

    public void setLeftDataItens(ArrayList<DataItem> leftDataItens) {
        this.leftDataItens = leftDataItens;
    }

    public ArrayList<DataItem> getRightDataItens() {
        return rightDataItens;
    }

    public void setRightDataItens(ArrayList<DataItem> rightDataItens) {
        this.rightDataItens = rightDataItens;
    }
}
