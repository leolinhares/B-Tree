import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by thiagoisaias on 4/27/16.
 */
public class Main {

    public static void print(Node root){
        System.out.println(root.getKeyLeft());
        System.out.println(root.getKeyRight());
        if (root.getLeft() != null){
            print(root.getLeft());
        }
        if (root.getMiddle() != null){
            print(root.getMiddle());
        }
        if (root.getRight() != null){
            print(root.getRight());
        }
    }

    public static void search(Node root, int key){
        if (key == root.getKeyLeft()){
            System.out.println(root.getLeftDataItens());
        }else if (key == root.getKeyRight()){
            System.out.println(root.getRightDataItens());
        }else{
            if (key < root.getKeyLeft()){
                search(root.getLeft(),key);
            }else if (key < root.getKeyRight()){
                search(root.getMiddle(),key);
            }else {
                search(root.getRight(),key);
            }
        }
    }
    public static void main(String[] args) {


        BTree bt = new BTree();
        bt.generateTree();
        bt.exportTree();

        bt.search(2007);

        /*
        ArrayList<Node> nodes = bt.createTree();
        Node root = bt.generateBTree(nodes);
        print(root);
        search(root,2008);

        for (Node node:nodes) {
            System.out.println("Node:");
            System.out.println(node.getKeyLeft());
            System.out.println(node.getLeftDataItens().size());
            System.out.println(node.getKeyRight());
            System.out.println(node.getRightDataItens().size());
        }*/


        /* ArrayList<DataItem> wineList = new ArrayList<>();
        ReadData rd = new ReadData();
        rd.read(wineList);
        Collections.sort(wineList);
        BTree bt = new BTree();
        bt.createTree(wineList);
        for (DataItem wine :
                wineList) {
            System.out.println(wine.getRid()+" " + wine.getAnoColheita());
        }
        */

//        String csvFile = "./data/wine.csv";
//        LineNumberReader br = null;
//        try {
//            br = new LineNumberReader(new FileReader(csvFile));
//            System.out.println(br.readLine());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }
}
