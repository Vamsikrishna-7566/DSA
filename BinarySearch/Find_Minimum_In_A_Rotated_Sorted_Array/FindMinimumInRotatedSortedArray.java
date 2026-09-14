/**
 * Finds the minimum in a nonempty rotated sorted array of distinct integers.
 * Time: O(log n). Auxiliary space: O(1).
 */
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int result = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (nums[low] <= nums[mid]) {
                // Left half is sorted: save its smallest value.
                result = Math.min(result, nums[low]);
                low = mid + 1;
            } else {
                // Right half is sorted: save its smallest value.
                result = Math.min(result, nums[mid]);
                high = mid - 1;
            }
        }

        return result;
    }
}
