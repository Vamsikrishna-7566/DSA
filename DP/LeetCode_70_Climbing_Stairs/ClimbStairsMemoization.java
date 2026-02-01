/**
 * Approach: Recursion + Memoization (Top-Down DP)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)  // memo array + recursion stack
 */
public class ClimbStairsMemoization {

    public int climbStairs(int n) {
        // Base cases
        if (n <= 1) {
            return 1;
        }

        // Memo array to store results for 0..n
        int[] memo = new int[n + 1];

        // Initialize memo with -1 (not computed)
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -1;
        }

        // Known base values
        memo[0] = 1;
        memo[1] = 1;

        return calculate(n, memo);
    }

    private int calculate(int n, int[] memo) {
        // If already computed, return cached value
        if (memo[n] != -1) {
            return memo[n];
        }

        // Compute, store, and return
        memo[n] = calculate(n - 1, memo) + calculate(n - 2, memo);
        return memo[n];
    }

    // Optional main method for local testing
    public static void main(String[] args) {
        ClimbStairsMemoization solution = new ClimbStairsMemoization();
        System.out.println(solution.climbStairs(5)); // Output: 8
    }
}
