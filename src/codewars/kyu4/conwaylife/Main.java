package codewars.kyu4.conwaylife;

import java.util.Arrays;

public class Main {

    public static int MAX_VALUE = Integer.MAX_VALUE;
    public static int MIN_VALUE = Integer.MIN_VALUE;

    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(getGeneration(new int[][]{
                {0, 0, 1, 1, 0, 1, 1, 1},
                {1, 0, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 0, 1},
                {0, 1, 0, 1, 1, 0, 1, 0},
                {0, 0, 1, 1, 1, 1, 1, 0},
                {1, 0, 1, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 0, 0, 1, 0},
                {1, 0, 1, 1, 1, 0, 0, 0}
        }, 1)));
    }

    public static int[][] getGeneration(int[][] cells, int generations) {
        int rowCount = cells.length;
        int colCount = cells[0].length;

        while (generations > 0) {
            int[][] nextGen = new int[rowCount][colCount];

            for (int row=0; row<rowCount; row++) {
                for (int col=0; col<colCount; col++) {
                    int currentCell = cells[row][col];
                    int neighbourCellsCount = getNeighboursCount(cells, row, col, rowCount, colCount);

                    if (currentCell == 1 && (neighbourCellsCount > 3 || neighbourCellsCount < 2)) {
                        nextGen[row][col] = 0;
                    } else if (currentCell == 0 && neighbourCellsCount == 3) {
                        nextGen[row][col] = 1;
                    } else {
                        nextGen[row][col] = currentCell;
                    }
                }
            }
            cells = nextGen;
            generations--;
        }

        return cropCells(cells);
    }


    public static int getNeighboursCount(int[][] cells, int row, int col, int rowCount, int colCount) {
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

        return neighbourCellsCount;
    }


    public static int[][] cropCells(int[][] cells) {
        int top = MAX_VALUE;
        int bottom = MIN_VALUE;
        int left = MAX_VALUE;
        int right = MIN_VALUE;

        for (int row=0; row<cells.length; row++) {
            for (int col=0; col<cells[0].length; col++) {
                if (cells[row][col] == 1) {
                    top = Math.min(top, row);
                    bottom = Math.max(bottom, row);
                    left = Math.min(left, col);
                    right = Math.max(right, col);
                }
            }
        }

        if (top == MAX_VALUE) {
            return new int[0][0];
        }

        int[][] cropped = new int[bottom-top+1][right-left+1];
        for (int row=top; row<=bottom; row++) {
            for (int col=left; col<=right; col++) {
                cropped[row-top][col-left] = cells[row][col];
            }
        }

        return cropped;
    }
}
