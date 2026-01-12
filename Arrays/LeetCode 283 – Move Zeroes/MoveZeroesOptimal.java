import java.util.Arrays;

/**
 * LeetCode 283 - Move Zeroes (Optimal - Two Pointers)
 *
 * Approach:
 * 1) Find the first index j where nums[j] == 0.
 * 2) Scan from i = j + 1 to end:
 *    - If nums[i] is non-zero, swap nums[i] with nums[j] and increment j.
 *
 * Time Complexity:  O(N)
 * Space Complexity: O(1)
 */
public class MoveZeroesOptimal {

    /**
     * Moves all zeroes to the end while maintaining order of non-zero elements.
     *
     * @param nums the input array to be modified in-place
     */
    public static void moveZeroes(int[] nums) {
        // j will point to the first zero in the array.
        int j = -1;

        // Find the first zero index and store it in j.
        for (int i = 0; i < nums.length; i++) {
            // If we find a zero, store its index and stop searching.
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // Edge case: if there is no zero in the array, it is already valid.
        if (j == -1) {
            return;
        }

        // Start scanning from the element right after the first zero (j + 1).
        for (int i = j + 1; i < nums.length; i++) {
            // If current element is non-zero, swap it with the element at index j.
            if (nums[i] != 0) {
                // Store nums[i] temporarily.
                int temp = nums[i];
                // Move the zero at nums[j] to position i.
                nums[i] = nums[j];
                // Place the non-zero value at position j.
                nums[j] = temp;
                // Move j forward to the next zero position.
                j++;
            }
        }
    }

    // Small driver for local testing (optional for LeetCode).
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums)); // Expected: [1, 3, 12, 0, 0]
    }
}
