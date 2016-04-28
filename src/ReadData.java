import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by thiagoisaias on 4/27/16.
 */
public class ReadData {

    public void read(){

        String csvFile = "./data/wine.csv";
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ",";

        try{
            br = new BufferedReader(new FileReader(csvFile));
            while((line = br.readLine()) != null){
                String[] wine = line.split(csvSplitBy);
                System.out.println(wine[2]);
                //Make your editions right here
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (br!=null){
                try{
                    br.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

}
