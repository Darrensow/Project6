package Main;

public class sort extends subset {
protected String[][] aftersort;
    public void sort(String columns) {
        aftersort=data.clone();
        int index = 0;
        for (int i = 0; i < aftersort[0].length; i++) {        // determine which colomun choosed
            if (aftersort[0][i].equals(columns)) {
                index = i;
                break;
            }
        }

        for (int pass = 1; pass < aftersort.length; pass++)    // sorting 
        {
            for (int i = 1; i < aftersort.length - 1; i++) {
                if (aftersort[i][index].compareTo(aftersort[i + 1][index]) > 0) {
                    String[] temp = aftersort[i];
                    aftersort[i] = aftersort[i+1];
                    aftersort[i+1] = temp;
                }
            }
        }
    }
    public String[][] sort(String columns,String[][] aftersort) {         // this one not use already 
        aftersort=data.clone();
        int index = 0;
        for (int i = 0; i < aftersort[0].length; i++) {
            if (aftersort[0][i].equals(columns)) {
                index = i;
                break;
            }
        }

        for (int i = 0; i < 10; i++) {

        }
        for (int pass = 1; pass < aftersort.length; pass++) // control number of comparison
        {
            for (int i = 1; i < aftersort.length - 1; i++) {
                if (aftersort[i][index].compareTo(aftersort[i + 1][index]) > 0) {
                    String[] temp = aftersort[i];
                    aftersort[i] = aftersort[i+1];
                    aftersort[i+1] = temp;
                }
            }
        }return aftersort;
    }
    public void display(){        // display 
        for (int i = 0; i < aftersort.length; i++) {
            for (int j = 0; j < aftersort[i].length; j++) {
                System.out.print(aftersort[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public String[][] getAftersort() {       // not use already
        return aftersort.clone();
    }
    
    
}
