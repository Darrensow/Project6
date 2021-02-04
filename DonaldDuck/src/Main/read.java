package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class read {

    protected String[][] data;
    private boolean start = false;  // use to read the first row only
    private String name;

    private int size = 0;

    public void readData() {
        int counter = 0;
        try {
            Scanner in = new Scanner(new FileInputStream("Files\\data.txt"));        // get size of data
            while (in.hasNextLine()) {
                String a = in.nextLine();
                String[] ar = a.split(",");
                if (size < ar.length) {
                    size = ar.length;
                }
                counter++;
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
        data = new String[counter][size];
        try {
            Scanner in = new Scanner(new FileInputStream("Files\\data.txt"));         // put data to array

            while (in.hasNextLine()) {

                for (int i = 0; i < data.length; i++) {
                    String a = in.nextLine();
                    String[] ar = a.split(",");
                    for (int j = 0; j < data[i].length; j++) {
                        data[i][j] = ar[j];
                    }
                }

            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
        System.out.println("data");                         //print data
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
