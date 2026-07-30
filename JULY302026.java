import java.util.ArrayDeque;
import java.util.Queue;
public class JULY302026{
    public int orangesRotting(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int[]> queue = new ArrayDeque<>();
        int freshCount = 0;
        
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        
        // If there are no fresh oranges to begin with, 0 minutes have elapsed
        if (freshCount == 0) return 0;
        
        int minutes = 0;
        int[] directions = {-1, 0, 1, 0, -1}; // Helper arrays for 4-directional movement (up, right, down, left)
        
        // Step 2: BFS to rot adjacent fresh oranges level by level
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            minutes++; // Increment time for the current level/minute
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                for (int d = 0; d < 4; d++) {
                    int nx = curr[0] + directions[d];
                    int ny = curr[1] + directions[d + 1];
                    
                    // Check boundaries and if the cell contains a fresh orange
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 1) {
                        grid[nx][ny] = 2; // Rot the fresh orange
                        queue.offer(new int[]{nx, ny});
                        freshCount--; // Reduce fresh orange count
                        
                        // Early exit if all fresh oranges are rotted
                        if (freshCount == 0) {
                            return minutes;
                        }
                    }
                }
            }
        }
        
        // Step 3: If fresh oranges remain, they couldn't be reached
        return freshCount == 0 ? minutes : -1;
    }
}

// • Time Complexity: O(M × N), where M and N are the grid dimensions.
// • Space Complexity: O(M × N) for the queue storage in the worst-case scenario.