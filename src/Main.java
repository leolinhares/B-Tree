import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by thiagoisaias on 4/27/16.
 */
public class Main {


    public static void main(String[] args) {


        ArrayList<DataItem> wineList = new ArrayList<>();
        ReadData rd = new ReadData();
        rd.read(wineList);
        Collections.sort(wineList);
        BTree bt = new BTree();
        bt.createTree(wineList);
        for (DataItem wine :
                wineList) {
            System.out.println(wine.getRid()+" " + wine.getAnoColheita());
        }


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
