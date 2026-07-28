import java.util.ArrayList;
import java.util.List;
public class JULY282026{
    private static final int[][] DIRECTIONS = {{-1,0},{1,0},{0,-1},{0,1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights){
        List<List<Integer>> result = new ArrayList<>();
        if(heights == null || heights.length == 0 || heights[0].length == 0){
            return result;
        }
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific, heights[i][0]);       // Left border (Pacific)
            dfs(heights, i, n - 1, atlantic, heights[i][n - 1]); // Right border (Atlantic)
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pacific, heights[0][j]);       // Top border (Pacific)
            dfs(heights, m - 1, j, atlantic, heights[m - 1][j]); // Bottom border (Atlantic)
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i);
                    cell.add(j);
                    result.add(cell);
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited, int prevHeight) {
        int m = heights.length;
        int n = heights[0].length;

        // Base cases: out of bounds, already visited, or lower than previous (can't flow uphill backwards)
        if (r < 0 || c < 0 || r >= m || c >= n || visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        // Traverse all 4 neighboring directions
        for (int[] dir : DIRECTIONS) {
            dfs(heights, r + dir[0], c + dir[1], visited, heights[r][c]);
        }
    }
}

//time complexity: O(M*N)
//space complexity: O(M*N)