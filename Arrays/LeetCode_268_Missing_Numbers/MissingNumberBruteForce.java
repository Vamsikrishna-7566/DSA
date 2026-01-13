import java.util.*;

public class MissingNumberBruteForce {

    // Brute force: for each value i in [0..N], scan the array to see if i exists.
    public static int missingNumber(int[] nums) {
        int n = nums.length;

        // i goes from 0 to n (inclusive) because the range is [0..n]
        for (int i = 0; i <= n; i++) {
            int flag = 0; // 0 means "not found yet"

            // scan the array to find i
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    flag = 1; // found
                    break;    // stop scanning
                }
            }

            // if flag is still 0, i is missing
            if (flag == 0) return i;
        }

        // problem guarantees one missing number, so this line should not be reached
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println("Missing: " + missingNumber(nums)); // Expected: 2
    }
}
