package Main;

public class StatisticsPackage extends read{
    protected double[] specificColumn;

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
    public void findAndAssignColumn(String categoryName){
        int categoryColumn = 0;         //locate the column
        specificColumn = new double[data.length - 1];
        for (int i = 0; i < data[0].length; i++) {
            //if the categoryName mathces the column name, store the column location(i)
            if (categoryName.equals(data[0][i])) {
                categoryColumn = i;
                break;
            }
        }

        //assign each of the values in that specific column into an array
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i+1][categoryColumn].equals(" ")) {
                specificColumn[i] = 0;
            } else {
                specificColumn[i] = Integer.parseInt(data[i+1][categoryColumn]);
            }
        }

        sortColumnValues();
    }

    //sort the integer array in ascending order
    private void sortColumnValues(){
        double[] b = specificColumn;
        for (int pass = 0; pass < b.length; pass++) {
            for (int i = 0; i < b.length - 1; i++) {
                if (b[i] > b[i+1]) {
                    double temp = b[i];
                    b[i] = b[i+1];
                    b[i+1] = temp;
                }
            }
        }
    }

    public void displayStatsValues(){
        System.out.println("Variance : " + getVariance());
        System.out.println("Standard Deviation : " + getStandardDeviation());
        System.out.println("Minimum Value : " + getMinValue());
        System.out.println("Maximum Value : " + getMaxValue());
        System.out.println("Median Value : " + getMedian());
        System.out.println("Mean Value : " + getMean());
        System.out.println("Mode : " + getModeForNumericColumn());
        System.out.println("Range of column : " + getRange());

    }

    public double getMean(){
        double x = 0;
        for (int i = 0; i < specificColumn.length; i++) {
            x += specificColumn[i];
        }
        double mean =  x / specificColumn.length;
        return Math.round(mean * 100) / 100.0;
    }

    //get the last element of the sorted array
    public double getMaxValue(){
        return specificColumn[specificColumn.length - 1];
    }

    //get the first element of the sorted array
    public double getMinValue(){
        return specificColumn[0];
    }

    public double getRange(){
        return getMaxValue() - getMinValue();
    }

    //Population Variance is used for this calculation. sample variance != population variance
    public double getVariance(){
        double mean = getMean();
        double summation = 0;
        for (int i = 0; i < specificColumn.length; i++) {
            summation += Math.pow(specificColumn[i] - mean, 2);
        }
        double variance = summation / specificColumn.length;
        return Math.round(variance * 100) / 100.0;
    }

    public double getStandardDeviation(){
        double valueStdDev = Math.sqrt(getVariance());
        return Math.round(valueStdDev * 100) / 100.0;
    }

    public double getMedian(){
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

    public String getModeForNumericColumn(){
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
        for(int i = 1; i < length; i++) {
            if(counterColumn[i] >= mode){
                mode = counterColumn[i];
            }
        }

        String str = "";
        for(int i = 0; i < length; i++) {
            if(counterColumn[i] == mode){
                str += clonedColumn[i] + " ";
            }
        }

        return str;
    }

}
