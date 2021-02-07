package Main;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);
    static double[] specificColumn;
    static String[] specificColumnString;

    public static void main(String[] args) {
//        calculate obj = new calculate();     //  calling must follow the last class(latest son class)
//        obj.readData();
//        obj.find();

        //testing statistics package, can delete after test
        StatisticsPackage a = new StatisticsPackage();
        a.readData();
        System.out.print("Enter the column name to check their statistics values : ");
        String columnName = s.nextLine();
        initiateStatisticsPack(columnName, a);
        a.displayStatsValuesForNonNumeric();
        String[] temp = a.getSpecificColumnString();
        System.out.println("NAME : ");
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }
        System.out.println();
        a.fillMissingValues("NAME", "KOK");
        a.displayStatsValuesForNonNumeric();

        System.out.println("NAME : ");
        for (int i = 0; i < temp.length; i++) {
            System.out.print(temp[i] + " ");
        }

    }

    //Call this method when the user wants to get the statistics values
    public static void initiateStatisticsPack(String categoryName, StatisticsPackage obj){
        if (obj.isColumnNumeric(categoryName)) {
            obj.assignColumnNumericValues(categoryName);
            specificColumn = obj.getSpecificColumn();
        } else {
            obj.assignColumnNonNumericValues(categoryName);
            specificColumnString = obj.getSpecificColumnString();
        }
    }


}
