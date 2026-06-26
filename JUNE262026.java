public class JUNE262026 {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (letters[mid] > target) {
                right = mid - 1;

            } else {//if letters[mid] <= target 
            //means right ptr didn't move and also updating left until bigger not found
                left = mid + 1;
            }
        }
        return letters[left % letters.length];
    }
}
//time complexity: O(log n)
//space complexity: O(1)s