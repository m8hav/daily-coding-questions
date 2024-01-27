class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
            BRUTE FORCE APPROACH

            Checking each row, each column, and each 3x3 box for each filled cell.
        */
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                
                for (int k = i + 1; k < 9; k++)
                    if (board[k][j] == board[i][j]) return false;
                for (int k = j + 1; k < 9; k++)
                    if (board[i][k] == board[i][j]) return false;
                int boxStartRow = (i / 3) * 3;
                int boxStartColumn = (j / 3) * 3;
                for (int k = boxStartRow; k < boxStartRow + 3; k++)
                    for (int l = boxStartColumn; l < boxStartColumn + 3; l++)
                        if (k != i && l != j && board[k][l] == board[i][j]) return false;
            }
        }
        return true;
    }
}