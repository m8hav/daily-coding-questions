class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
            POSITION SIGNATURE METHOD

            - traverse full board
            - create signature strings for existing values
                for their row, column, and 3x3 box. Examples:
                 - 0th row, value 3: 3@row0
                 - 0th column, value 3: 3@col0
                 - top-right box, value 3: 3@box02
            - add these strings to a set for each existing value.
            - if value already exists, return false.

        */

        Set<String> signs = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                if (!signs.add(board[i][j] + "@row" + i)
                    || !signs.add(board[i][j] + "@col" + j)
                    || !signs.add(board[i][j] + "@box" + i/3 + j/3))
                    return false;
            }
        }
        
        return true;
    }
}