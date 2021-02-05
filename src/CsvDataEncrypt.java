import java.io.BufferedReader; 
import java.io.FileReader; 

import java.io.BufferedWriter; 
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.FileWriter; 
import java.io.IOException; 

public class CsvDataEncrypt {
    // get data from input.csv
    // write all results to output.csv
    // verifiedInput.csv and verifiedOutput.csv include some examples with SDES cipher text from internet
    public void csvDataEncrypt() {
        File csv = new File("src/data/output.csv");
        if (csv.exists()) { // delete if a output.csv already existed
            csv.delete();
        }
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/data/input.csv"));
            BufferedWriter bw = new BufferedWriter(new FileWriter(csv, true)); 
            bw.write("Key"+","+"Plaintext"+","+"SDES output"); // the csv file generate at this line
            reader.readLine();
            String line = null;
            
            while ((line = reader.readLine()) != null) {
                String item[] = line.split(","); // get key and plaintext
                String dataKey = item[0];
                String dataPT = item[1];
                int[] orgKey = utils.String2Array(dataKey);
                int[] plainText = utils.String2Array(dataPT);
                
                int[] CT = SDES.sDES(orgKey, plainText);

                String CTString = utils.array2String(CT);
                System.out.println(CTString);
                System.out.println("Encyption done!");

                bw.newLine();
                bw.write(dataKey + "," + dataPT + "," + CTString);
            }

            bw.flush(); // write all lines to output.csv
            reader.close();
            bw.close();
        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
          } catch (IOException e) { 
            e.printStackTrace(); 
          } catch (Exception e) { 
            e.printStackTrace(); 
        } 
    }
}
