import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Created by leolinhares on 02/07/2016.
 */
public class BTree {

    private ArrayList<Node> node_list;
    private Node root;

    public BTree(){
        this.node_list = new ArrayList<Node>();
        this.root = null;
    }

    public void search(int key){

    }

    public ArrayList createTree(){
        ArrayList<DataItem> wineList = new ArrayList<DataItem>();
        ArrayList<Node> auxList = new ArrayList<Node>();
        ReadData.read(wineList);
        Collections.sort(wineList);


        Node node = new Node();
        node.setKeyLeft(wineList.get(0).anoColheita);
        node.getLeftDataItens().add(wineList.get(0));
        for(int i=0;i<wineList.size()-1;i++){
            if(wineList.get(i).anoColheita == wineList.get(i+1).anoColheita){
                if(wineList.get(i).anoColheita == node.getKeyLeft()) {
                    node.getLeftDataItens().add(wineList.get(i + 1));
                }
                else{
                    node.getRightDataItens().add(wineList.get(i+1));
                }
            }
            else if(node.getKeyRight() == -1){
                node.setKeyRight(wineList.get(i+1).anoColheita);
                node.getRightDataItens().add(wineList.get(i+1));
            }
            else{
                auxList.add(node);
                Node newNode = new Node();
                newNode.setKeyLeft(wineList.get(i+1).anoColheita);
                newNode.getLeftDataItens().add(wineList.get(i+1));
                node = newNode;
            }
        }
        auxList.add(node);
        return auxList;
    }

    public void exportTree(){

    }


    public ArrayList<Node> getNode_list() {
        return node_list;
    }

    public void setNode_list(ArrayList<Node> node_list) {
        this.node_list = node_list;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
