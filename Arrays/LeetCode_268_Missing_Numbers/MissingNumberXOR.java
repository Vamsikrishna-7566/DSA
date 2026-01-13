import java.util.*;

public class MissingNumberXOR {

    // XOR approach: (0^1^...^n) ^ (nums[0]^nums[1]^...^nums[n-1]) = missing
    public static int missingNumber(int[] nums) {
        int n = nums.length;

        int xorAll = 0; // XOR of 0..n
        int xorArr = 0; // XOR of array elements

        // XOR array elements
        for (int i = 0; i < n; i++) {
            xorArr ^= nums[i];
        }

        // XOR 0..n
        for (int i = 0; i <= n; i++) {
            xorAll ^= i;
        }

        return xorAll ^ xorArr;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println("Missing: " + missingNumber(nums)); // Expected: 2
    }
}
