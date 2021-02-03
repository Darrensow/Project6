package Main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class remove extends sort {

    Scanner sc = new Scanner(System.in);

    public void remove(String[] element, int num) {                  // remove double / repeated elements
        System.out.println("run remove method \n");
        String[][] remove_after = new String[data.length - 1][];       /// create a array that not have first row
        for (int i = 0; i < remove_after.length; i++) {
            remove_after[i] = data[i + 1];
        }
        int[] index = new int[element.length];
        int counter = 0;
        for (int i = 0; i < data[0].length; i++) {                // find which colomun choosed
            if (data[0][i].equals(element[counter])) {
                index[counter] = i;
                counter++;
            }
            if (counter >= element.length) {
                break;
            }
        }
        for (int i = 0; i < index.length; i++) {
            int start = 0;
            int end = 0;
            int anum = index[i];
            Arrays.sort(remove_after, Comparator.comparing(a -> a[anum]));          //  sorting   a[anum]  mean sort based on colomun [anum] 
            for (int j = 0; j < remove_after.length - 1; j++) {
                if (remove_after[j][anum].equals(remove_after[j + 1][anum])) {          //  find which the sama element start and end
                    end++;
                } else if (num > (end - start + 1)) {              /// handle posibility where user want remain the number3 data but there only have 2 data 
                    for (int k = start + 1; k <= end; k++) {
                        remove_after[k][0] = " ";
                    }
                    start = end;
                } else {
                    for (int k = start; k <= end; k++) {         // set the first elements to empty // i assume the fisrt elements is primary key can not empty one
                        if (k != start + (num - 1)) {
                            remove_after[k][0] = " ";
                        }
                    }
                    start = end;
                }
            }
        }

        Arrays.sort(remove_after, Comparator.comparing(a -> a[0]));        //sort so empty will at infront
        int size = 0;
        for (int i = 0; i < remove_after.length; i++) {
            if (remove_after[i][0].equals(" ")) {               // only can which no empty 
                size++;
            }
        }
        String[][] remove = new String[remove_after.length - size + 1][];      
        int con = 1;
        remove[0] = data[0].clone();                             // copy the data to remove(array) with have first row one
        for (int i = 0; i < remove_after.length; i++) {
            if (i >= size) {
                remove[con] = remove_after[i];
                con++;
            }
        }

        for (int i = 0; i < remove.length; i++) {           // display
            for (int j = 0; j < remove[i].length; j++) {
                System.out.print(remove[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public void remove(String[] elements) {           // remove empty 
        int[] index = new int[elements.length];
        int counter = 0;
        for (int i = 0; i < elements.length; i++) {     // find which colomun choosed 
            for (int j = 0; j < data[0].length; j++) {
                if (elements[i].equals(data[0][j])) {
                    index[counter] = j;
                    counter++;
                    break;
                }
            }
        }
        String[][] remove_after = data.clone();
        int size = 0;
        for (int i = 1; i < remove_after.length; i++) {         //  sama la just check whether condition mean then set ti to empty
            int con = 0; 
            for (int j = 0; j < index.length; j++) {
                if (remove_after[i][index[j]].equals(" ")) {
                    con++;
                }
            }
            if (con == elements.length) {
                remove_after[i][0] = " ";
                size++;
            }
        }
        int con = 0;
        String[][] remove = new String[remove_after.length - size][];          // create a new array with the empty one deleted
        for (int i = 0; i < remove_after.length; i++) {
            if (!remove_after[i][0].equals(" ")) {
                remove[con] = remove_after[i];
                con++;
            }
        }

        for (int i = 0; i < remove.length; i++) {                         // display
            for (int j = 0; j < remove[i].length; j++) {
                System.out.print(remove[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
