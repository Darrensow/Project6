package Updated_Main;

import java.io.*;
import java.util.Scanner;

public class DataFrame {
    protected String fileName;
    protected String[][] dataFrame;
    private int size = 0;

    public DataFrame() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String[][] getDataFrame() {
        return dataFrame;
    }

    public void setDataFrame(String[][] dataFrame) {
        this.dataFrame = dataFrame;
    }

    public void readData(){
        int counter = 0;
        try {
            Scanner in = new Scanner(new FileInputStream(fileName));        // get size of data
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
        dataFrame = new String[counter][size];
        try {
            Scanner in = new Scanner(new FileInputStream(fileName));         // put data to array

            while (in.hasNextLine()) {

                for (int i = 0; i < dataFrame.length; i++) {
                    String a = in.nextLine();
                    String[] ar = a.split(",");
                    for (int j = 0; j < dataFrame[i].length; j++) {
                        dataFrame[i][j] = ar[j];
                    }
                }

            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
    }

    public void writeData(String newFileName){
        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(newFileName));           // write data to file
            for (int i = 0; i < dataFrame.length; i++) {
                String a = "";
                for (int j = 0; j < dataFrame[i].length; j++) {
                    a += dataFrame[i][j] + ",";
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
