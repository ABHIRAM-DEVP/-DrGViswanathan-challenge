public class JULY172026 {
    private boolean[][] row = new boolean[9][9];
    private boolean[][] col = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];

    public void solveSudoku(char[][] board) {
        // Initialize state based on the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    row[i][num] = true;
                    col[j][num] = true;
                    block[i / 3][j / 3][num] = true;
                }
            }
        }
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int i, int j) {
        // Move to next row if current row is finished
        if (j == 9) { i++; j = 0; }
        if (i == 9) return true; // Puzzle solved
        
        // Skip filled cells
        if (board[i][j] != '.') return backtrack(board, i, j + 1);

        for (int num = 0; num < 9; num++) {
            if (!row[i][num] && !col[j][num] && !block[i / 3][j / 3][num]) {
                // Apply move
                board[i][j] = (char) (num + '1');
                row[i][num] = col[j][num] = block[i / 3][j / 3][num] = true;

                if (backtrack(board, i, j + 1)) return true;

                // Backtrack
                board[i][j] = '.';
                row[i][num] = col[j][num] = block[i / 3][j / 3][num] = false;
            }
        }
        return false;
    }
}

//time complexity: O(9^m)
//Space Complexity: O(1)