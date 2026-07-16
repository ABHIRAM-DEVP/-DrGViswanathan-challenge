import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JULY162026{
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n]; // r + c
        boolean[] diag2 = new boolean[2 * n]; // r - c + n
        
        backtrack(0, board, res, cols, diag1, diag2, n);
        return res;
    }

    private void backtrack(int r, char[][] board, List<List<String>> res, 
                           boolean[] cols, boolean[] d1, boolean[] d2, int n) {
        if (r == n) {
            res.add(construct(board));
            return;
        }

        for (int c = 0; c < n; c++) {
            if (!cols[c] && !d1[r + c] && !d2[r - c + n]) {
                // Place queen
                board[r][c] = 'Q';
                cols[c] = d1[r + c] = d2[r - c + n] = true;
                
                // Recurse
                backtrack(r + 1, board, res, cols, d1, d2, n);
                
                // Backtrack
                board[r][c] = '.';
                cols[c] = d1[r + c] = d2[r - c + n] = false;
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> path = new ArrayList<>();
        for (char[] row : board) path.add(new String(row));
        return path;
    }
}

//time complexity: O(N!) - The number of valid arrangements of N queens on an N x N chessboard is factorial in nature, leading to a time complexity of O(N!).
//space complexity:O(N^2) - The space complexity is O(N^2) due to the storage of the board and the result list, which can hold up to N! solutions, each of size N.