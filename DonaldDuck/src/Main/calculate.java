package Main;

import java.util.Arrays;
import java.util.Comparator;

public class calculate extends remove{
    public void find(){
        boolean[] is_digit=new boolean[data[0].length];       // determine whether this colomun is digit or letter
        for (int i = 0; i < is_digit.length; i++) {
            is_digit[i]=true;
        }
        
        for (int i = 1; i< data.length; i++) {                      // checking method
            for (int j = 0; j < data[i].length; j++) {
                for (int k = 0; k < data[i][j].length(); k++) {
                    if(Character.isLetter(data[i][j].charAt(k))==true&& !data[i][j].equals(" ")){     
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


class KNN extends calculate {

    private double[][] nearest_distance;
    private String[][] nearest_distanceC;
    private int category;
    private int max_value;
    private String mode = "";

    public void draw_graphR(String element1, String element2, double x_point, double y_point) {
        nearest_distance = new double[data.length - 1][2];
        int[] elements = new int[2];
        double[] x = new double[data.length - 1];
        double[] y = new double[data.length - 1];
        for (int i = 0; i < data[0].length; i++) {
            if (data[0][i].equals(element1)) {
                elements[0] = i;
            }
            if (data[0][i].equals(element2)) {
                elements[1] = i;
            }
        }
        for (int i = 1; i < data.length; i++) {
            if (!" ".equals(data[i][elements[0]]) && !" ".equals(data[i][elements[1]])) {
                x[i - 1] = Double.parseDouble(data[i][elements[0]]);
                y[i - 1] = Double.parseDouble(data[i][elements[1]]);
                nearest_distance[i - 1][0] = find_nearest(x[i - 1], y[i - 1], x_point, y_point);                 
                nearest_distance[i - 1][1] = y[i - 1];
            } else {
                nearest_distance[i - 1][0] = Integer.MAX_VALUE;                        
                nearest_distance[i - 1][1] = 0;
            }
        }

        Arrays.sort(nearest_distance, Comparator.comparing(a -> a[0]));
    }

    public void draw_graphC(String element1, String element2, String cato, double x_point, double y_point) {      // cato = category that they want
        nearest_distanceC = new String[data.length - 1][2];
        int[] elements = new int[2];
        double[] x = new double[data.length - 1];
        double[] y = new double[data.length - 1];
        for (int i = 0; i < data[0].length; i++) {
            if (data[0][i].equals(element1)) {
                elements[0] = i;
            }
            if (data[0][i].equals(element2)) {
                elements[1] = i;
            }
            if (data[0][i].equals(cato)) {
                category = i;
            }
        }
        char symbol = 'A';
        for (int i = 1; i < data.length; i++) {
            if (!" ".equals(data[i][elements[0]]) && !" ".equals(data[i][elements[1]])) {                 // set coordiante
                x[i - 1] = Double.parseDouble(data[i][elements[0]]);        
                y[i - 1] = Double.parseDouble(data[i][elements[1]]);
                nearest_distanceC[i - 1][0] = "" + find_nearest(x[i - 1], y[i - 1], x_point, y_point);
                nearest_distanceC[i - 1][1] = data[i][category];
            } else {
                nearest_distanceC[i - 1][0] = "" + Integer.MAX_VALUE;
                nearest_distanceC[i - 1][1] = "invalid";
            }
        }
        Arrays.sort(nearest_distanceC, Comparator.comparing(a -> a[0]));
    }

    public double find_nearest(double x, double y, double x_point, double y_point) {                       /// find nearest distance
        double distance_x = Math.abs(x - x_point);
        double distance_y = Math.abs(y - y_point);
        double result = Math.abs(Math.sqrt((distance_x * distance_x) + (distance_y * distance_y)));
        return result;
    }

    public String KNN(int num_K, String kind) {               //return value
        String result = "";
        if (kind.equals("R")) {
            double sum = 0;
            for (int i = 0; i < num_K; i++) {
                sum += nearest_distance[i][1];
            }
            result = "" + sum / num_K;
        } else if (kind.endsWith("C")) {
            for (int i = 0; i < num_K; i++) {
                int cont = 0;
                for (int j = 0; j < num_K; j++) {
                    if (nearest_distanceC[i][1] == nearest_distanceC[j][1]) {
                        cont++;
                    }
                }
                if (cont > max_value) {
                    max_value = cont;
                    mode = nearest_distanceC[i][1];
                }
            }
            result = mode;
        } else {

            result = "invalid innput";
        }
        return result;
    }
}
