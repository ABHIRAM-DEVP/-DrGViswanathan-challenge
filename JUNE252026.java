public class JUNE252026 {
    public int[] sortedSquares(int[] nums) {
        //2 pointer - merge sort

        //for the last negative and first non negative

        int k=0;
        int n = nums.length;
        while(k<n && nums[k]<0){
            k++;
        }
        int i = k-1; //last  negative
        int j = k ;  //first non negative
        int indexResult = 0;
        //obviously, lowest negative(i) will be beside lowest positive(j)

        int result[] = new int[n];
        while(i>=0 && j<n){  //2 pointers

            int leftSquare = nums[i]*nums[i];
            int rightSquare =  nums[j]*nums[j];
            if(leftSquare>rightSquare){
                result[indexResult++] = rightSquare;
                j++;
            }
            else{
                result[indexResult++] = leftSquare;
                i--;
            }
          

            //for remaining i and j
        }
        while(j<n){
            int rightSquare =  nums[j]*nums[j];
            result[indexResult++] = rightSquare;
            j++;
        }
        while(i>=0){
            int leftSquare = nums[i]*nums[i];
            result[indexResult++] = leftSquare;
            i--;
        }
        return result;
    }
}

//time complexity: O(n)
//space complexity: O(n)