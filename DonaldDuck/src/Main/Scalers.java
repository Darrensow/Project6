package Main;

public class Scalers extends StatisticsPackage{
    protected double [] standardscale;
    protected double [] minmaxscale;

    public Scalers(double[] standardscale, double[] minmaxscale) {
        this.standardscale = standardscale;
        this.minmaxscale = minmaxscale;
    }

    //subtarct the mean from all values in the column and divide by the standard deviation
    public double [] StandardScaling(){
        standardscale = new double [specificColumn.length];
        for (int i = 0; i < specificColumn.length ; i++) {
            standardscale[i] = (specificColumn[i] - getMean()) / getStandardDeviation() ;
        }
        return standardscale;
    }

    //subtracting the min from all values in the column and dividing by the range
    public double[] MinMaxScaling(){
        minmaxscale = new double[specificColumn.length];
        for (int i = 0; i < specificColumn.length; i++) {
            minmaxscale[i] = (specificColumn[i] - getMinValue()) / getRange();
        }
        return minmaxscale;
    }
}
