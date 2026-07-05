public class JULY052026 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int trappedWater = 0;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax= height[left];//Found a new wall, can't hold water here
                }else{
                    trappedWater+=leftMax - height[left]; // Trapped water!
                }
                left++; // Move inward
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right]; // Found a new wall, can't hold water here
                } else {
                    trappedWater += rightMax - height[right]; // Trapped water!
                }
                right--; // Move inward
            }
        }
        return trappedWater;
    }
}

//time complexity: O(n)
//spapce complexity: O(1)