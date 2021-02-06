package Main;

public class Scalers extends StatisticsPackage{
    protected double [] standardscale;
    protected double [] minmaxscale;

    public Scalers(double[] standardscale, double[] minmaxscale) {
        this.standardscale = standardscale;
        this.minmaxscale = minmaxscale;
    }

    //display the output for standardscaling
    public void displayStandardScaling(){
        standardscale = new double [specificColumn.length];
        for (int i = 0; i < specificColumn.length ; i++) {
            standardscale[i] = StandardScaling(specificColumn[i]);
        }

        System.out.println("Standard Scaling : ");
        for (int i = 0; i < standardscale.length; i++) {
            if (i == 0) {
                System.out.print("{" + standardscale[i] + ", ");
            }
            else if (i>0 && i < standardscale.length-1) {
                System.out.print(standardscale[i] + ", ");
            }
            else{
                System.out.print(standardscale[i] + "}");
            }
        }
    }

    //display the output of MinMaxScaling
    public void displayMinMaxScaling(){
        minmaxscale = new double[specificColumn.length];
        for (int i = 0; i < specificColumn.length ; i++) {
            minmaxscale[i] = MinMaxScaling(specificColumn[i]);
        }

        System.out.println("Min Max Scaling : ");
        for (int i = 0; i < minmaxscale.length; i++) {
            if (i == 0) {
                System.out.print("{" + minmaxscale[i] + ", ");
            }
            else if (i>0 && i < minmaxscale.length-1) {
                System.out.print(minmaxscale[i] + ", ");
            }
            else{
                System.out.print(minmaxscale[i] + "}");
            }
        }
    }

    //subtarct the mean from all values in the column and divide by the standard deviation
    public double StandardScaling(double Specific){
         return (Specific - getMean()) / getStandardDeviation() ;
    }

    //subtracting the min from all values in the column and dividing by the range
    public double MinMaxScaling(double specific){
        return (specific - getMinValue()) / getRange();
    }
}
