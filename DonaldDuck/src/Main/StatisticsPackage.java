package Main;

import java.util.Arrays;

public class StatisticsPackage extends read {
    protected double[] specificColumn;
    protected String[] specificColumnString;

    public double[] getSpecificColumn() {
        return specificColumn;
    }

    public String[] getSpecificColumnString() {
        return specificColumnString;
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
        //data[column].length is the length of the header row
        for (int column = 0; column < data[column].length; column++) {
            if (data[0][column].equals(columnName)) {
                for (int row = 1; row < data[column].length; row++) {
                    for (int ch = 0; ch < data[column][row].length(); ch++) {
                        if (Character.isLetter(data[column][row].charAt(ch)) && !data[column][row].equals(" ")) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    /***
     * Filling in the missing values(" ") for a specific column
     * <p>
     *     Start by locating the specific column of the DataFrame to fill in the missing values.
     *     Proceed to check if the entry in the column is (" "), if yes, assign the specificValue
     *     to the DataFrame. Then reassigns the values of the column into the instance array variable.
     * </p>
     * @param columnName name of the column with missing values
     * @param specificValue value input by the user
     */
    public void fillMissingValues(String columnName, double specificValue){
        for (int column = 0; column < data[column].length; column++) {
            if (data[0][column].equals(columnName)) {
                for (int row = 1; row < data.length; row++) {
                    if (data[row][column].equals(" ")) {
                        data[row][column] = String.valueOf(specificValue);
                        assignColumnNumericValues(columnName);
                    }
                }
            }
        }
    }

    public void fillMissingValues(String columnName, String specificValue){
        for (int column = 0; column < data[column].length; column++) {
            if (data[0][column].equals(columnName)) {
                for (int row = 1; row < data.length; row++) {
                    if (data[row][column].equals(" ")) {
                        data[row][column] = specificValue;
                        assignColumnNonNumericValues(columnName);
                    }
                }
            }
        }
    }
    /**
     * Create a sorted array of the numeric values in the column.
     * <p>
     *     Assigns each of the values into the array. If the the data of the
     *     entry is missing, the data will be treated as ZERO.
     * </p>
     * <li> Array size = number of rows - 1 (excludes the header)
     * <li> 'data[i + 1][columnLocation]' excludes the header when copying the values into the array
     *
     * @param categoryName the column name passed in by the user
     */
    public void assignColumnNumericValues(String categoryName){
        int columnLocation = 0;
        if (specificColumn == null) {
            specificColumn = new double[data.length - 1];
        }
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
                specificColumn[i] = Double.parseDouble(data[i + 1][columnLocation]);
            }
        }

        Arrays.sort(specificColumn);
    }

    /**
     * Create am array of the non-numeric values in the column.
     * <li> Array size = number of rows - 1 (excludes the header)
     * <li> 'data[i + 1][columnLocation]' excludes the header when copying the values into the array
     * @param categoryName the column name passed in by the user
     */
    public void assignColumnNonNumericValues(String categoryName){
        int columnLocation = 0;
        if (specificColumnString == null) {
            specificColumnString = new String[data.length - 1];
        }
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
        System.out.println("Mode : " + getModeForNonNumericColumn());
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
        int middle = specificColumn.length / 2;
        if (specificColumn.length % 2 == 0) {
            return (specificColumn[middle - 1] + specificColumn[middle]) / 2.0;
        } else { //else if odd number of entries, get the middle entry { 1, 3, 4, 9, 10 } -> 4
            return specificColumn[middle];
        }
    }

    public String getModeForNumericColumn() {
        double[] clonedColumn = specificColumn.clone();
        int length = specificColumn.length;
        int[] counterColumn = new int[length]; //keep track of the occurrence of each element in 'clonedColumn' array

        //assign the occurrence of each entry in the column to the counterColumn array
        System.out.print("LISTS : ");
        for (int i = 1; i < length; i++) {
            int count = 1;
            System.out.print(clonedColumn[i] + " ");
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
    public String getModeForNonNumericColumn(){
        String[] clonedColumn = specificColumnString.clone();
        int length = specificColumnString.length;
        int[] counterColumn = new int[length]; //keep track of the occurrence of each element in 'clonedColumn' array

        //assign the occurrence of each entry in the column to the counterColumn array
        for (int i = 1; i < length; i++) {
            int count = 1;
            if (clonedColumn[i].equals("")) {
                counterColumn[i] = 0;
            } else {
                for (int j = i + 1; j < length; j++) {
                    if (clonedColumn[i].equals(clonedColumn[j])) {
                        count++;
                        clonedColumn[j] = "";
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

}
