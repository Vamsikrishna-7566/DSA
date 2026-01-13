import java.util.*;

public class MissingNumberHashArray {

    // Hash array approach: mark presence using an auxiliary array of size n+1.
    public static int missingNumber(int[] nums) {
        int n = nums.length;

        // hash[i] will be >0 if i is present in nums
        int[] hash = new int[n + 1];

        // mark presence
        for (int i = 0; i < n; i++) {
            hash[nums[i]]++;
        }

        // find first index with 0 occurrences
        for (int i = 0; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println("Missing: " + missingNumber(nums)); // Expected: 2
    }
}
