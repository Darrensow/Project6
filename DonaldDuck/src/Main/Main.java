package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        calculate obj = new calculate();
        obj.readdata();
        obj.find();
    }
}
