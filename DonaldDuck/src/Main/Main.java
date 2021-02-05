package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        calculate obj = new calculate();     //  calling must follow the last class(lastest son class)
        obj.readData();
        obj.find();

        //testing statistics package, can delete after test
        StatisticsPackage a = new StatisticsPackage();
        a.readData();
        a.findAndAssignColumn("weight");
        double[] test = a.getSpecificColumn();
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i]  + " ");
        }
        a.displayStatsValuesForNumeric();
    }
}
