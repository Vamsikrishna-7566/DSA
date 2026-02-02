/**
 * Frog Jump - Memoization (Top-Down DP)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)  // memo array + recursion stack
 */
public class FrogJumpMemoization {

    public int frogJump(int[] heights) {
        int n = heights.length;

        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            memo[i] = -1;
        }

        return dp(n - 1, heights, memo);
    }

    private int dp(int index, int[] heights, int[] memo) {
        if (index == 0) {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        int left = dp(index - 1, heights, memo)
                + Math.abs(heights[index] - heights[index - 1]);

        int right = Integer.MAX_VALUE;
        if (index > 1) {
            right = dp(index - 2, heights, memo)
                    + Math.abs(heights[index] - heights[index - 2]);
        }

        memo[index] = Math.min(left, right);
        return memo[index];
    }

    public static void main(String[] args) {
        FrogJumpMemoization solution = new FrogJumpMemoization();
        int[] heights = {10, 20, 30, 10};
        System.out.println(solution.frogJump(heights));
    }
}
