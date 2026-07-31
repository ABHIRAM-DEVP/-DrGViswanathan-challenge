import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class JULY312026{
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>(numCourses);

        for (int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            adj.get(prerequisite).add(course); // Edge from prerequisite -> course
            indegree[course]++;
        }
        
        // Step 2: Push all nodes with 0 indegree into the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        // Step 3: Process the queue (BFS)
        int completedCourses = 0;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            completedCourses++;
            
            // Decrement indegree of neighboring courses
            for (int neighbor : adj.get(curr)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        
        // Step 4: If we completed all courses, there are no cycles
        return completedCourses == numCourses;
    
    }
}



//Time Complexity: O(V + E)
//Space Complexity: O(V + E)