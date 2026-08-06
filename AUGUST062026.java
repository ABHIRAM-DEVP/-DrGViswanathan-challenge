import java.util.*;
public class AUGUST062026 {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) indices[i] = i;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int[] tree = new int[n + 1];
        Integer[] res = new Integer[n];

        for (int i = n - 1; i >= 0; i--) {
            int rank = lowerBound(sorted, nums[i]) + 1;
            res[i] = query(tree, rank - 1);
            update(tree, rank, 1, n);
        }

        return Arrays.asList(res);
    }

    private void update(int[] tree, int i, int delta, int n) {
        for (; i <= n; i += i & -i) tree[i] += delta;
    }

    private int query(int[] tree, int i) {
        int sum = 0;
        for (; i > 0; i -= i & -i) sum += tree[i];
        return sum;
    }

    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] >= target) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}

//Time Complexity: O(N log N)
//Space Complexity: O(N)