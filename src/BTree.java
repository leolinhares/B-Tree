import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by leolinhares on 02/07/2016.
 */
public class BTree {

    private ArrayList<Node> nodeList;
    private Node root;

    public BTree(){
        this.nodeList = new ArrayList<Node>();
        this.root = null;
    }

    public void search(int key){

        String csvFile = "./data/index.csv";
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";
        int lines = 0;

        try{
            br = new BufferedReader(new FileReader("./data/index.csv"));
            line = br.readLine();
            String[] nodeFile = line.split(csvSplitBy);
            System.out.println(nodeFile[0]);
            while(nodeFile[6].equalsIgnoreCase("false")){
                if(key<Integer.parseInt(nodeFile[1])){
                    //LEFT
                    int leftChild = Integer.parseInt(nodeFile[3]);
                    int id = Integer.parseInt(nodeFile[0]);
                    for(int i=1;i<=(Integer.parseInt(nodeFile[3])-Integer.parseInt(nodeFile[0]));i++){
                        line = br.readLine();
                        nodeFile = line.split(csvSplitBy);
                    }
                }
                else if(key>=Integer.parseInt(nodeFile[1]) && key<Integer.parseInt(nodeFile[2])){
                    //CENTER
                    int centerChild = Integer.parseInt(nodeFile[4]);
                    int id = Integer.parseInt(nodeFile[0]);
                    for(int i=1;i<=centerChild-id;i++){
                        line = br.readLine();
                        nodeFile = line.split(csvSplitBy);
                    }
                }
                else{
                    //RIGHT
                    int rightChild = Integer.parseInt(nodeFile[5]);
                    int id = Integer.parseInt(nodeFile[0]);
                    for(int i=1;i<=Integer.parseInt(nodeFile[5])-Integer.parseInt(nodeFile[0]);i++){
                        line = br.readLine();
                        nodeFile = line.split(csvSplitBy);
                    }
                }
                System.out.println(nodeFile[0]);
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }


    }

    public void generateTree(){
        Node node1 = new Node();
        nodeList.add(node1);
        node1.setId(1);
        Node node2 = new Node();
        nodeList.add(node2);
        node2.setId(2);
        Node node3 = new Node();
        nodeList.add(node3);
        node3.setId(3);
        Node node4 = new Node();
        nodeList.add(node4);
        node4.setId(4);
        Node node5 = new Node();
        nodeList.add(node5);
        node5.setId(5);
        Node node6 = new Node();
        nodeList.add(node6);
        node6.setId(6);
        Node node7 = new Node();
        nodeList.add(node7);
        node7.setId(7);
        Node node8 = new Node();
        nodeList.add(node8);
        node8.setId(8);

        this.setRoot(node1);
        node1.setKeyLeft(2005);
        node1.setLeft(node2);
        node1.setMiddle(node3);
        node2.setKeyLeft(2002);
        node2.setLeft(node4);
        node2.setMiddle(node5);
        node3.setKeyLeft(2007);
        node3.setKeyRight(2011);
        node3.setLeft(node6);
        node3.setMiddle(node7);
        node3.setRight(node8);
        node4.setKeyLeft(1998);
        node4.setKeyRight(2001);
        node4.setLeaf(true);
        node5.setKeyLeft(2002);
        node5.setKeyRight(2003);
        node5.setLeaf(true);
        node6.setKeyLeft(2005);
        node6.setKeyRight(2006);
        node6.setLeaf(true);
        node7.setKeyLeft(2007);
        node7.setKeyRight(2008);
        node7.setLeaf(true);
        node8.setKeyLeft(2011);
        node8.setKeyRight(2012);
        node8.setLeaf(true);
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
        try {
            FileWriter writer = new FileWriter("./data/index.csv");

            for (Node node:nodeList) {
                writer.append(Integer.toString(node.getId()));
                writer.append(",");
                if(node.getKeyLeft()!=-1){writer.append(Integer.toString(node.getKeyLeft()));}
                else{writer.append("-");}
                writer.append(",");
                if(node.getKeyRight()!=-1)writer.append(Integer.toString(node.getKeyRight()));
                else{writer.append("-");}
                writer.append(",");
                if(node.getLeft()!=null){writer.append(Integer.toString(node.getLeft().getId()));}
                else {writer.append("-");}
                writer.append(",");
                if(node.getLeft()!=null){writer.append(Integer.toString(node.getMiddle().getId()));}
                else {writer.append("-");}
                writer.append(",");
                if(node.getRight()!=null){writer.append(Integer.toString(node.getRight().getId()));}
                else{writer.append("-");}
                writer.append(",");
                writer.append(Boolean.toString(node.isLeaf()));
                writer.append(",");
                writer.append("{array left}");
                writer.append(",");
                writer.append("{array right}");
                writer.append("\n");
            }

            //generate whatever data you want

            writer.flush();
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<Node> getNodeList() {
        return nodeList;
    }

    public void setNodeList(ArrayList<Node> nodeList) {
        this.nodeList = nodeList;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
