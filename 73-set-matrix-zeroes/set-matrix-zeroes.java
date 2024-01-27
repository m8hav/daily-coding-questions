class Solution {
    public void setZeroes(int[][] matrix) {
        /*
            - using first row and columns as memory for 0 rows and columns
            - using boolean variables to store whether first row
                and column would be 0 later too
            - traversing from 1st row's 1st column to last row and column
                and marking all cells 0 where (that column in first row)
                or (that row in first column) is 0;
            - checking whether first row or column should be 0
                with boolean variable and marking them 0;
        */

        boolean fr = false, fc = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        if (fr) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (fc) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}