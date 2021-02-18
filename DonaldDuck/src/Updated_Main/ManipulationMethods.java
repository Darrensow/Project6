package Updated_Main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ManipulationMethods extends DataFrame {
    private String[][] aftersort;
    private int row;
    private int col;
    private String[] elements;
    Scanner sc = new Scanner(System.in);

    public void subset(String[] elements) {
        this.elements = elements;
        int[] index = new int[elements.length];           // determine which column to chose
        int counter = 0;
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < dataFrame[0].length; j++) {
                if (dataFrame[0][j].equals(elements[i])) {
                    index[counter] = j;
                    counter++;
                    break;
                }
            }
        }
        for (int i = 0; i < dataFrame.length; i++) {          //print data
            int con = 0;                                // determine index of index(array)
            for (int j = 0; j < dataFrame[i].length; j++) {
                if (j == index[con]) {
                    System.out.print(dataFrame[i][j] + " ");
                    con++;
                    if (con >= index.length) {
                        break;
                    }
                }
            }
            System.out.println("");
        }

    }

    public void subset(int row, int col) {      //  sama as above just this given row and colomun
        this.row = row;
        this.col = col;
        for (int i = 0; i < row + 2; i++) {
            for (int j = 0; j < col + 2; j++) {
                System.out.print(dataFrame[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void sort(String columns) {
        aftersort=dataFrame.clone();
        int index = 0;
        for (int i = 0; i < aftersort[0].length; i++) {        // determine which colomun choosed
            if (aftersort[0][i].equals(columns)) {
                index = i;
                break;
            }
        }

        for (int pass = 1; pass < aftersort.length; pass++)    // sorting
        {
            for (int i = 1; i < aftersort.length - 1; i++) {
                if (aftersort[i][index].compareTo(aftersort[i + 1][index]) > 0) {
                    String[] temp = aftersort[i];
                    aftersort[i] = aftersort[i+1];
                    aftersort[i+1] = temp;
                }
            }
        }
    }
    public String[][] sort(String columns,String[][] aftersort) {         // this one not use already
        aftersort=dataFrame.clone();
        int index = 0;
        for (int i = 0; i < aftersort[0].length; i++) {
            if (aftersort[0][i].equals(columns)) {
                index = i;
                break;
            }
        }

        for (int i = 0; i < 10; i++) {

        }
        for (int pass = 1; pass < aftersort.length; pass++) // control number of comparison
        {
            for (int i = 1; i < aftersort.length - 1; i++) {
                if (aftersort[i][index].compareTo(aftersort[i + 1][index]) > 0) {
                    String[] temp = aftersort[i];
                    aftersort[i] = aftersort[i+1];
                    aftersort[i+1] = temp;
                }
            }
        }return aftersort;
    }
    public void display(){        // display
        for (int i = 0; i < aftersort.length; i++) {
            for (int j = 0; j < aftersort[i].length; j++) {
                System.out.print(aftersort[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public String[][] getAftersort() {       // not use already
        return aftersort.clone();
    }

    public void remove(String[] element, int num) {                  // remove double / repeated elements
        System.out.println("run remove method \n");
        String[][] remove_after = new String[dataFrame.length - 1][];       /// create a array that not have first row
        for (int i = 0; i < remove_after.length; i++) {
            remove_after[i] = dataFrame[i + 1];
        }
        int[] index = new int[element.length];
        int counter = 0;
        for (int i = 0; i < dataFrame[0].length; i++) {                // find which colomun choosed
            if (dataFrame[0][i].equals(element[counter])) {
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
        remove[0] = dataFrame[0].clone();                             // copy the data to remove(array) with have first row one
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
            for (int j = 0; j < dataFrame[0].length; j++) {
                if (elements[i].equals(dataFrame[0][j])) {
                    index[counter] = j;
                    counter++;
                    break;
                }
            }
        }
        String[][] remove_after = dataFrame.clone();
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

    public void find(){
        boolean[] is_digit=new boolean[dataFrame[0].length];       // determine whether this colomun is digit or letter
        for (int i = 0; i < is_digit.length; i++) {
            is_digit[i]=true;
        }

        for (int i = 1; i< dataFrame.length; i++) {                      // checking method
            for (int j = 0; j < dataFrame[i].length; j++) {
                for (int k = 0; k < dataFrame[i][j].length(); k++) {
                    if(Character.isLetter(dataFrame[i][j].charAt(k))==true&& !dataFrame[i][j].equals(" ")){
                        is_digit[j] = false;
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < is_digit.length; i++) {       // display boolean array
            System.out.println(is_digit[i]);
        }
    }
}
