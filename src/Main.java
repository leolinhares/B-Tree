import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by thiagoisaias on 4/27/16.
 */
public class Main {

    public static void main(String[] args) {


        BTree bt = new BTree();
        bt.BFS(bt.createBTree());
        bt.exportTree();
        String[] aux;
        aux = bt.search(1997);

        if (aux == null) {
            System.out.println("O ano escolhido nao possui vinho cadastrado no banco");
        } else {
            for (String s : aux) {
                String csvFile = "./data/wine.csv";
                try {
                    BufferedReader br = new BufferedReader(new FileReader(csvFile));
                    br.skip(Integer.parseInt(s)); //pula as linhas que ja foram lidas
                    System.out.println(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
