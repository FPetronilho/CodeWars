package codewars.kyu4.conwaylife;

public class Main {

    public static void main(String[] args) {

        getGeneration(new int[5][10], 1);
    }

    public static int[][] getGeneration(int[][] cells, int generations) {
        int rowCount = cells.length;
        int colCount = cells[0].length;

        while (generations >= 0) {
            for (int row=0; row<rowCount; row++) {
                for (int col=0; col<colCount; col++) {
                    int currentCell = cells[row][col];
                    int neighbourCellsCount = 0;

                    if (row>0 && col>0 && cells[row-1][col-1] == 1) {
                        neighbourCellsCount++;
                    }

                    if (col>0 && cells[row][col-1] == 1) {
                        neighbourCellsCount++;
                    }

                    if (row<rowCount-1 && col>0 && cells[row+1][col-1] == 1) {
                        neighbourCellsCount++;
                    }

                    if (row>0 && cells[row-1][col] == 1) {
                        neighbourCellsCount++;
                    }

                    if (row<rowCount-1 && cells[row+1][col] == 1) {
                        neighbourCellsCount++;
                    }

                    if (row>0 && col<colCount-1 && cells[row-1][col+1] == 1) {
                        neighbourCellsCount++;
                    }

                    if (col<colCount-1 && cells[row][col+1] == 1) {
                        neighbourCellsCount++;
                    }

                    if (row<rowCount-1 && col<colCount-1 && cells[row+1][col+1] == 1) {
                        neighbourCellsCount++;
                    }

                    if (currentCell == 1 && (neighbourCellsCount > 3 || neighbourCellsCount < 2)) {
                        currentCell = 0;
                    } else if (currentCell == 0 && neighbourCellsCount == 3) {
                        currentCell = 1;
                    }
                }
            }

            generations--;
        }

        return cells;
    }
}
