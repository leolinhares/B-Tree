import java.util.ArrayList;

/**
 * Created by thiagoisaias on 4/27/16.
 */
public class Main {


    public static void main(String[] args) {
        NodeLeaf n = new NodeLeaf();
        ArrayList ridList = new ArrayList();
        ridList.add(21);
        ridList.add(12);
        ridList.add(5);
        n.dataEntry.put(2000,ridList);
        n.dataEntry.get(2000).add(27);

        //System.out.println(n.dataEntry);
        ReadData rd = new ReadData();
        rd.read();
    }
}
