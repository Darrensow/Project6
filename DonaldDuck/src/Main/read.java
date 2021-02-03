/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainq6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author xianp
 */
public class read {

    protected String[][] data;
    private boolean start = false;
    private String name;

    private int size = 0;

    public void readdata() {
        int counter = 0;
        try {
            Scanner in = new Scanner(new FileInputStream("data.txt"));

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
            Scanner in = new Scanner(new FileInputStream("data.txt"));

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
        System.out.println("data");
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
