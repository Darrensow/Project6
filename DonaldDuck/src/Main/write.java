package Main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class write extends read {

    public void writefile() {
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream("create.txt"));           // write data to file
            for (int i = 0; i < data.length; i++) {
                String a = "";
                for (int j = 0; j < data[i].length; j++) {
                    a += data[i][j] + ",";
                }

                a = a.substring(0, a.length() - 1);
                System.out.println(a);
                out.println(a);               
            }         
            out.close();           
        } catch (IOException e) {
            System.out.println("Problem with output file");
        }
    }


}
