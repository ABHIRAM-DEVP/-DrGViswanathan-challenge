public class JULY272026 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    islandCount++;
                    dfs(grid, r, c, rows, cols); // Sink the entire island
                }
            }
        }

        return islandCount;
    }

    private void dfs(char[][] grid, int r, int c, int rows, int cols) {
        if (r < 0 || c < 0 || r >= rows || c >= cols || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        dfs(grid, r - 1, c, rows, cols); // Up
        dfs(grid, r + 1, c, rows, cols); // Down
        dfs(grid, r, c - 1, rows, cols); // Left
        dfs(grid, r, c + 1, rows, cols); // Right
    }
}

//time complexity: O(M*N)
//space complexity: O(M*N)