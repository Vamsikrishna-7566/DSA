/**
 * Find the Duplicate Number using Floyd cycle detection.
 * Requires n + 1 values in [1, n] and one distinct repeated value.
 * Time: O(n). Extra space: O(1). Does not modify nums.
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        // Phase 1: Find a meeting point inside the cycle.
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find the cycle entrance.
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        // The entrance index is the duplicated number.
        return slow;
    }
}
