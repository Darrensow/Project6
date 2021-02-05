package Main;

import java.util.Arrays;

public class StatisticsPackage extends read {
    protected double[] specificColumn;
    protected String[] specificColumnString;

    public double[] getSpecificColumn() {
        return specificColumn;
    }

    /***
     * Locate the column in which the user wants to obtain the
     * variance, standard deviation, ..., range and put it into
     * an integer array to be sorted.
     * categoryColumn - used to locate the column
     * The array inside this method is used to help calculate the
     * values. The length the array is subtracted by one
     * because the number of columns always excludes the header(row1) of the
     * DataFrame.
     * @param categoryName
     *
     */
    public void findAndAssignColumn(String categoryName) {
        if (isColumnNumeric(categoryName)) {
            assignColumnNumericValues(categoryName);
        } else {
            assignColumnNonNumericValues(categoryName);
        }

    }

    /**
     * Determines if the entries in the column are numeric/non-numeric values
     * <p>
     *     Goes through the specified column of the DataFrame and checking each
     *     character of the entries. This is achieved by using three for loops where
     *     the the row = 1 which excludes the header during the checking process.
     * </p>
     * @param   columnName the column name passed in by the user
     * @return  {@code true} if all the entires in the column are numeric;
     *          {@code false} otherwise(non-numeric).
     */
    public boolean isColumnNumeric(String columnName){
        for (int column = 0; column < data.length; column++) {
            if (data[0][column].equals(columnName)) {
                for (int row = 1; row < data[column].length; row++) {
                    for (int ch = 0; ch < data[column][row].length(); ch++) {
                        if (Character.isLetter(data[row][column].charAt(ch)) && !data[column][row].equals(" ")) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * Create a sorted array of the numeric values in the column.
     * <p>
     *     Assigns each of the values into the array. If the the data of the
     *     entry is missing, the data will be treated as ZERO.
     * </p>
     * <li> Array size = number of rows - 1
     * <li> 'data[i + 1][columnLocation]' excludes the header when copying the values into the array
     *
     * @param categoryName the column name passed in by the user
     */
    public void assignColumnNumericValues(String categoryName){
        int columnLocation = 0;
        specificColumn = new double[data.length - 1];
        for (int i = 0; i < data[0].length; i++) {
            if (categoryName.equals(data[0][i])) {
                columnLocation = i;
                break;
            }
        }

        for (int i = 0; i < data.length - 1; i++) {
            if (data[i + 1][columnLocation].equals(" ")) {
                specificColumn[i] = 0;
            } else {
                specificColumn[i] = Integer.parseInt(data[i + 1][columnLocation]);
            }
        }

        Arrays.sort(specificColumn);
    }

    /**
     * Create am array of the non-numeric values in the column.
     * <li> Array size = number of rows - 1
     * <li> 'data[i + 1][columnLocation]' excludes the header when copying the values into the array
     * @param categoryName the column name passed in by the user
     */
    public void assignColumnNonNumericValues(String categoryName){
        int columnLocation = 0;
        specificColumnString = new String[data.length - 1];
        for (int i = 0; i < data[0].length; i++) {
            if (categoryName.equals(data[0][i])) {
                columnLocation = i;
                break;
            }
        }

        //assign each of the values in that specific column into an array
        for (int i = 0; i < data.length - 1; i++) {
            specificColumnString[i] = data[i + 1][columnLocation];
        }
    }
    public void displayStatsValuesForNumeric() {
        System.out.println("Variance : " + getVariance());
        System.out.println("Standard Deviation : " + getStandardDeviation());
        System.out.println("Minimum Value : " + getMinValue());
        System.out.println("Maximum Value : " + getMaxValue());
        System.out.println("Median Value : " + getMedian());
        System.out.println("Mean Value : " + getMean());
        System.out.println("Mode : " + getModeForNumericColumn());
        System.out.println("Range of column : " + getRange());
    }

    public void displayStatsValuesForNonNumeric() {
//        System.out.println("Mode : " + getModeForNonNumericColumn());
    }


    public double getMean() {
        double x = 0;
        for (int i = 0; i < specificColumn.length; i++) {
            x += specificColumn[i];
        }
        double mean = x / specificColumn.length;
        return Math.round(mean * 100) / 100.0;
    }

    //get the last element of the sorted array
    public double getMaxValue() {
        return specificColumn[specificColumn.length - 1];
    }

    //get the first element of the sorted array
    public double getMinValue() {
        return specificColumn[0];
    }

    public double getRange() {
        return getMaxValue() - getMinValue();
    }

    //Population Variance is used for this calculation. sample variance != population variance
    public double getVariance() {
        double mean = getMean();
        double summation = 0;
        for (int i = 0; i < specificColumn.length; i++) {
            summation += Math.pow(specificColumn[i] - mean, 2);
        }
        double variance = summation / specificColumn.length;
        return Math.round(variance * 100) / 100.0;
    }

    public double getStandardDeviation() {
        double valueStdDev = Math.sqrt(getVariance());
        return Math.round(valueStdDev * 100) / 100.0;
    }

    public double getMedian() {
        //if the number of entries are even number, then get the two middle numbers and divide by 2
        // { 1, 3, 4, 9, 10, 20 } -> 7.5
        if (specificColumn.length % 2 == 0) {
            int middle = specificColumn.length / 2;
            return (specificColumn[middle - 1] + specificColumn[middle]) / 2.0;
        } else { //else if odd number of entries, get the middle entry { 1, 3, 4, 9, 10 } -> 4
            int middle = specificColumn.length / 2;
            return specificColumn[middle];
        }
    }

    public String getModeForNumericColumn() {
        double[] clonedColumn = specificColumn.clone();
        int length = specificColumn.length;
        int[] counterColumn = new int[length]; //keep track of the occurrence of each element in 'clonedColumn' array

        //assign the occurrence of each entry in the column to the counterColumn array
        for (int i = 1; i < length; i++) {
            int count = 1;
            if (clonedColumn[i] == -1) {
                counterColumn[i] = 0;
            } else {
                for (int j = i + 1; j < length; j++) {
                    if (clonedColumn[i] == clonedColumn[j]) {
                        count++;
                        clonedColumn[j] = -1;
                    }
                }
                counterColumn[i] = count;
            }
        }

        int mode = counterColumn[0];
        for (int i = 1; i < length; i++) {
            if (counterColumn[i] >= mode) {
                mode = counterColumn[i];
            }
        }

        String str = "";
        for (int i = 0; i < length; i++) {
            if (counterColumn[i] == mode) {
                str += clonedColumn[i] + " ";
            }
        }

        return str;
    }
//    public String getModeForNonNumericColumn(){
//
//    }
}
