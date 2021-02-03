package mainq6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class remove extends sort {

    Scanner sc = new Scanner(System.in);

    public void remove(String[] element, int num) {
        System.out.println("run remove method \n");
        String[][] remove_after = new String[data.length - 1][];
        for (int i = 0; i < remove_after.length; i++) {
            remove_after[i] = data[i + 1];
        }
        int[] index = new int[element.length];
        int counter = 0;
        for (int i = 0; i < data[0].length; i++) {
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
            Arrays.sort(remove_after, Comparator.comparing(a -> a[anum]));
            for (int j = 0; j < remove_after.length - 1; j++) {
                if (remove_after[j][anum].equals(remove_after[j + 1][anum])) {
                    end++;
                } else if (num > (end - start + 1)) {
                    for (int k = start + 1; k <= end; k++) {
                        remove_after[k][0] = " ";
                    }
                    start = end;
                } else {
                    for (int k = start; k <= end; k++) {
                        if (k != start + (num - 1)) {
                            remove_after[k][0] = " ";
                        }
                    }
                    start = end;
                }
            }
        }

        Arrays.sort(remove_after, Comparator.comparing(a -> a[0]));
        int size = 0;
        for (int i = 0; i < remove_after.length; i++) {
            if (remove_after[i][0].equals(" ")) {
                size++;
            }
        }
        String[][] remove = new String[remove_after.length - size + 1][];
        int con = 1;
        remove[0] = data[0].clone();
        for (int i = 0; i < remove_after.length; i++) {
            if (i >= size) {
                remove[con] = remove_after[i];
                con++;
            }
        }

        for (int i = 0; i < remove.length; i++) {
            for (int j = 0; j < remove[i].length; j++) {
                System.out.print(remove[i][j] + " ");
            }
            System.out.println("");
        }

    }

    public void remove(String[] elements) {
        int[] index = new int[elements.length];
        int counter = 0;
        for (int i = 0; i < elements.length; i++) {
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
        for (int i = 1; i < remove_after.length; i++) {
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
        String[][] remove = new String[remove_after.length - size][];
        for (int i = 0; i < remove_after.length; i++) {
            if (!remove_after[i][0].equals(" ")) {
                remove[con] = remove_after[i];
                con++;
            }
        }

        for (int i = 0; i < remove.length; i++) {
            for (int j = 0; j < remove[i].length; j++) {
                System.out.print(remove[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
