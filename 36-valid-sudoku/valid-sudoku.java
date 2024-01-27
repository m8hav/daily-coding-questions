class Solution {
    public boolean isValidSudoku(char[][] board) {
        /*
            POSITION SIGNATURE METHOD

            - traverse full board
            - create signature strings for existing values
                for their row, column, and 3x3 block. Examples:
                 - 0th row, value 3: 0(3)
                 - 0th column, value 3: (3)0
                 - top-right block, value 3: 0(3)2
            - add these strings to a set for each existing value.
            - if value already exists, return false.

        */

        Set<String> signs = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                String signMid = "(" + board[i][j] + ")";
                if (!signs.add(i + signMid)
                    || !signs.add(signMid + j)
                    || !signs.add(i / 3 + signMid + j / 3))
                    return false;
            }
        }
        
        return true;
    }
}