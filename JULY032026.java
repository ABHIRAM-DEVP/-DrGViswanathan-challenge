public class JULY032026 {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            // Calculate the current width
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentWater = width * currentHeight;
            maxWater = Math.max(maxWater, currentWater);

            //Move the pointer that points to the shorter line, to find taller height container while decreasing the width from maximum possible width to smaller one
            if (height[left] < height[right]) {
                left++;
            } 
            else {
                right--;
            }
        }
        return maxWater;
    }

}


//time complexity: O(n)
//space complexity: O(1)