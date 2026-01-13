import java.util.*;

public class MissingNumberSumFormula {

    // Sum formula: missing = expectedSum(0..n) - actualSum(nums)
    public static int missingNumber(int[] nums) {
        int n = nums.length;

        // Use long to avoid overflow if n is large
        long expected = (long) n * (n + 1) / 2;

        long actual = 0;
        for (int i = 0; i < n; i++) {
            actual += nums[i];
        }

        return (int) (expected - actual);
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println("Missing: " + missingNumber(nums)); // Expected: 2
    }
}
