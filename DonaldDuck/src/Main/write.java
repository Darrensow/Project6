/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainq6;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author xianp
 */
public class write extends read {

    public void writefile() {
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream("create.txt"));
            for (int i = 0; i < data.length; i++) {
                String a="";
                for (int j = 0; j < data[i].length; j++) {
                    a+= data[i][j]+",";
                }

                a=a.substring(0,a.length()-1);
                System.out.println(a);
                out.println(a);               
            }         
            out.close();           
        } catch (IOException e) {
            System.out.println("Problem with output file");
        }
    }


}