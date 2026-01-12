import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LeetCode 283 - Move Zeroes (Brute Force)
 *
 * Approach:
 * 1) Store all non-zero elements in a temporary list.
 * 2) Copy list elements back to the array.
 * 3) Fill the remaining positions with zeroes.
 *
 * Time Complexity:  O(N)
 * Space Complexity: O(N)
 */
public class MoveZeroesBruteForce {

    /**
     * Moves all zeroes to the end while maintaining order of non-zero elements.
     *
     * @param nums the input array to be modified in-place
     */
    public static void moveZeroes(int[] nums) {
        // Create a list to store all non-zero values.
        List<Integer> nonZero = new ArrayList<>();

        // Loop through the array and collect non-zero elements.
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not zero, add it to the list.
            if (nums[i] != 0) {
                nonZero.add(nums[i]);
            }
        }

        // Copy all non-zero elements back into the nums array from index 0.
        for (int i = 0; i < nonZero.size(); i++) {
            nums[i] = nonZero.get(i);
        }

        // Fill the rest of the array with zeroes.
        for (int i = nonZero.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // Small driver for local testing (optional for LeetCode).
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums)); // Expected: [1, 3, 12, 0, 0]
    }
}
