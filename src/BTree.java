import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import com.sun.tools.javac.code.Type;

import java.io.*;
import java.util.*;

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

    public String[] search(int key){

        String csvFile = "./data/index.csv";
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";
        String[] data = null;
        int lines = 0;

        try{
            br = new BufferedReader(new FileReader("./data/index.csv"));
            line = br.readLine();
            String[] nodeFile = line.split(csvSplitBy);
            while(nodeFile[6].equalsIgnoreCase("false")){
                if(key<Integer.parseInt(nodeFile[1])){
                    //LEFT
                    int leftChild = Integer.parseInt(nodeFile[3]);
                    int id = Integer.parseInt(nodeFile[0]);
                    for(int i=1;i<=leftChild-id;i++){
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
                    for(int i=1;i<=rightChild-id;i++){
                        line = br.readLine();
                        nodeFile = line.split(csvSplitBy);
                    }
                }

                if(key == Integer.parseInt(nodeFile[1])){ //LEFT
                     data = nodeFile[7].split("/");
                }
                else{ //RIGHT
                     data = nodeFile[8].split("/");
                }
            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        return data;

    }

    public ArrayList bulkLoading(){
        ArrayList<DataItem> wineList = new ArrayList<DataItem>();
        ArrayList<Node> auxList = new ArrayList<Node>();
        ReadData.read(wineList);
        Collections.sort(wineList);


        Node node = new Node();
        node.setKeyLeft(wineList.get(0).anoColheita);
        node.getLeftDataItens().add(wineList.get(0));
        node.setLeaf(true);
        for(int i=0;i<wineList.size()-1;i++){
            if(wineList.get(i).anoColheita == wineList.get(i+1).anoColheita){
                if(wineList.get(i).anoColheita == node.getKeyLeft()) {
                    node.getLeftDataItens().add(wineList.get(i + 1));
                }
                else{
                    node.getRightDataItens().add(wineList.get(i+1));
                }
            }
            else if(node.getKeyRight() == 9999){
                node.setKeyRight(wineList.get(i+1).anoColheita);
                node.getRightDataItens().add(wineList.get(i+1));
            }
            else{
                auxList.add(node);
                Node newNode = new Node();
                newNode.setKeyLeft(wineList.get(i+1).anoColheita);
                newNode.getLeftDataItens().add(wineList.get(i+1));
                newNode.setLeaf(true);
                node = newNode;
            }
        }
        auxList.add(node);
        return auxList;
    }

    public void exportTree() {
        try {
            FileWriter writer = new FileWriter("./data/index.csv");

            for (Node node : nodeList) {
                writer.append(Integer.toString(node.getId()));
                writer.append(",");
                if (node.getKeyLeft() != -1) {
                    writer.append(Integer.toString(node.getKeyLeft()));
                } else {
                    writer.append("-");
                }
                writer.append(",");
                if (node.getKeyRight() != -1) writer.append(Integer.toString(node.getKeyRight()));
                else {
                    writer.append("-");
                }
                writer.append(",");
                if (node.getLeft() != null) {
                    writer.append(Integer.toString(node.getLeft().getId()));
                } else {
                    writer.append("-");
                }
                writer.append(",");
                if (node.getLeft() != null) {
                    writer.append(Integer.toString(node.getMiddle().getId()));
                } else {
                    writer.append("-");
                }
                writer.append(",");
                if (node.getRight() != null) {
                    writer.append(Integer.toString(node.getRight().getId()));
                } else {
                    writer.append("-");
                }
                writer.append(",");
                writer.append(Boolean.toString(node.isLeaf()));
                writer.append(",");
                if(node.getLeftDataItens().isEmpty()){writer.append("-");}
                else {
                    for (DataItem data : node.getLeftDataItens()) {
                        writer.append(Integer.toString(data.getRid()));
                        writer.append("/");
                    }
                }
                writer.append(",");
                if(node.getLeftDataItens().isEmpty()){writer.append("-");}
                else{
                    for(DataItem data:node.getRightDataItens()){
                        writer.append(Integer.toString(data.getRid()));
                        writer.append("/");
                    }
                }
                writer.append("\n");
            }

            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Node generateBTree(){
        ArrayList<Node> node_list = bulkLoading();
        Iterator<Node> it  = node_list.iterator();
        Node root = new Node();
        Node currentNode = new Node(); // cria nó vazio

        Node first = it.next();
        Node second = it.next();
        currentNode.setLeft(first);
        currentNode.setMiddle(second);
        currentNode.setKeyLeft(second.getKeyLeft());

        while (it.hasNext()){
            if (currentNode.hasSpace()){
                Node next = it.next();
                //esquerda tem espaco
                if (currentNode.getKeyLeft() == -1){

                }
                //direita tem espaco
                else if(currentNode.getKeyRight() == 9999){
                    currentNode.setRight(next);
                    currentNode.setKeyRight(next.getKeyLeft());
                }
                currentNode.setMiddle(second);
                currentNode.setKeyLeft(second.getKeyLeft());

            }else {
                Node newNode = new Node();
                Node newRoot = new Node();
                Node next = it.next();
                newNode.setLeft(currentNode.getRight());
                newNode.setMiddle(next);
                newNode.setKeyLeft(next.getKeyLeft());
                Node next1 = it.next();
                newNode.setRight(next1);
                newNode.setKeyRight(next1.getKeyLeft());

                newRoot.setLeft(currentNode);
                newRoot.setMiddle(newNode);
                newRoot.setKeyLeft(currentNode.getKeyRight());


                currentNode.setRight(null);
                currentNode.setKeyRight(9999);

                currentNode = newNode;
                root = newRoot;

            }
        }

        return root;
    }

    public void BFS(Node root){
        Deque<Node> queue = new ArrayDeque<Node>();
        Node current = new Node();
        int cont = 1;
        queue.add(root);

        while(!queue.isEmpty()){
            current = queue.removeFirst();
            current.setId(cont);
            this.nodeList.add(current);

            if(current.getLeft()!= null){
                queue.add(current.getLeft());
            }
            if(current.getMiddle()!= null){
                queue.add(current.getMiddle());
            }
            if(current.getRight()!=null){
                queue.add(current.getRight());
            }
            cont++;
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
