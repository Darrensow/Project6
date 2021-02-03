package Main;

public class subset extends write {

    private int row;
    private int col;
    private String[] elements;

    public void subset(String[] elements) {
        this.elements = elements;
        int[] index = new int[elements.length];
        int counter = 0;
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[0][j].equals(elements[i])) {
                    index[counter] = j;
                    counter++;
                    break;
                }
            }
        }
       for (int i = 0; i < data.length; i++) {
            int con = 0;
            for (int j = 0; j < data[i].length; j++) {
                if (j == index[con]) {
                    System.out.print(data[i][j] + " ");
                    con++;
                    if (con >= index.length) {
                        break;
                    }
                }
            }
            System.out.println("");
        }

    }

    public void subset(int row, int col) {
        this.row = row;
        this.col = col;
        for (int i = 0; i < row + 2; i++) {
            for (int j = 0; j < col + 2; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
