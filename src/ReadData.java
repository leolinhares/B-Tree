import java.io.*;
import java.util.ArrayList;

/**
 * Created by thiagoisaias on 4/27/16.
 */
public class ReadData {

    public static void read(ArrayList wineList){

        String csvFile = "./data/wine.csv";
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ", ";
        int lines = 0;
        try{
            //for (int i = 0; i <= 30; i++){
            do{
                br = new BufferedReader(new FileReader(csvFile));
                br.skip(lines); //pula as linhas que ja foram lidas
                line = br.readLine();
                if (line == null){
                    break;
                }
                String[] wine = line.split(csvSplitBy);
                DataItem item = new DataItem();
                item.setRid(lines);
                item.setAnoColheita(Integer.parseInt(wine[3]));

                wineList.add(item);
                lines += line.length()+1; // salva quanto foi lido nessa linha

                br.close();
            }while(line!=null);

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
