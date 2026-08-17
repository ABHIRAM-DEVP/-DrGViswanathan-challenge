public class AUGUST172026{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image[sr][sc] != newColor){
            fill(image, sr, sc, image[sr][sc], newColor);
        }
        return image;
    }
    
    private void fill(int[][] image, int r, int c, int oldColor, int newColor){
        if(r < 0 || c < 0 || r >= image.length || c >= image[0].length || image[r][c] != oldColor) return;
        
        image[r][c] = newColor;
        
        fill(image, r + 1, c, oldColor, newColor);
        fill(image, r - 1, c, oldColor, newColor);
        fill(image, r, c + 1, oldColor, newColor);
        fill(image, r, c - 1, oldColor, newColor);
    }
}

//time complexity: O(n)
//space complexity: O(n)