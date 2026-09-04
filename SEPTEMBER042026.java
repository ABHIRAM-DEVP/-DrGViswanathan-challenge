public class SEPTEMBER042026{
    private int count = 0;

    public int totalNQueens(int n){
        int limit = (1 << n) - 1;
        backtrack(0, 0, 0, limit);
        return count;
    }

    private void backtrack(int cols, int diag1, int diag2, int limit){
        if(cols == limit){
            count++;
            return;
        }
        int availablePositions = limit & ~(cols | diag1 | diag2);

        while(availablePositions != 0){
            int position = availablePositions & -availablePositions;
            availablePositions -= position;
            backtrack(cols | position, (diag1 | position) >> 1, (diag2 | position)<< 1, limit);
        }
    }
}

//time complexity: O(n!)
//space complexity: O(n)