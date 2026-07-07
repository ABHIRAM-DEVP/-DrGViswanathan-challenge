class JULY072026 {
    
    public double computeMedian(int[] nums1, int[] nums2) {
        long low = Math.min(nums1.length > 0 ? nums1[0] : Integer.MAX_VALUE, nums2.length > 0 ? nums2[0] : Integer.MAX_VALUE);
        long high = Math.max(nums1.length > 0 ? nums1[nums1.length - 1] : Integer.MIN_VALUE, nums2.length > 0 ? nums2[nums2.length - 1] : Integer.MIN_VALUE);
        
        int totalLength = nums1.length + nums2.length;
        int targetK = (totalLength + 1) / 2; 

        while (low <= high) {
            long midValue = low + (high - low) / 2;
            int count = countLessThanEqual(nums1, nums2, midValue);
            
            if (count < targetK) {
                low = midValue + 1;
            } else {
                high = midValue - 1;
            }
        }
        
        // Handle even total length safely by looking up the exact next ranking element
        if (totalLength % 2 == 0) {
            return (low + getNextElement(nums1, nums2, targetK)) / 2.0;
        }
        return (double) low;
    }

    public int computeBS(int l, int r) {
        return l + (r - l) / 2;
    }

    public int countLessThanEqual(int[] nums1, int[] nums2, long targetValue) {
        int l1 = 0, l2 = 0;
        int r1 = nums1.length - 1, r2 = nums2.length - 1;

        while (l1 <= r1 || l2 <= r2) {
            int mid1 = (l1 <= r1) ? computeBS(l1, r1) : -1;
            int mid2 = (l2 <= r2) ? computeBS(l2, r2) : -1;

            if (mid1 != -1) {
                if (nums1[mid1] <= targetValue) l1 = mid1 + 1;
                else r1 = mid1 - 1;
            }

            if (mid2 != -1) {
                if (nums2[mid2] <= targetValue) l2 = mid2 + 1;
                else r2 = mid2 - 1;
            }
        }
        return l1 + l2; 
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) return 0.0;
        return computeMedian(nums1, nums2);
    }

    // Fixed helper: Finds the next sequential element by matching the K-th index count rank
    private double getNextElement(int[] nums1, int[] nums2, int targetK) {
        int l1 = 0, l2 = 0;
        int p1 = 0, p2 = 0;
        
        // Use a simple two-pointer step to find the exact element right after targetK
        for (int i = 0; i <= targetK; i++) {
            int current;
            if (p1 < nums1.length && (p2 >= nums2.length || nums1[p1] <= nums2[p2])) {
                current = nums1[p1];
                p1++;
            } else {
                current = nums2[p2];
                p2++;
            }
            // This is the element at position (targetK + 1)
            if (i == targetK) {
                return current;
            }
        }
        return 0.0;
    }
}

//time complexity: O(log(Max-Min) * (log M + log N))
//space complexity: O(1)