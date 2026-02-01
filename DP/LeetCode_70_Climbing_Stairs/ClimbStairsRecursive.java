/**
 * Approach: Pure Recursion (No Memoization)
 *
 * Time Complexity: O(2^n)
 * Space Complexity: O(n)  // recursion stack
 */
public class ClimbStairsRecursive {

    public int climbStairs(int n) {
        // Base cases
        if (n <= 1) {
            return 1;
        }

        // Recursive relation
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // Optional main method for local testing
    public static void main(String[] args) {
        ClimbStairsRecursive solution = new ClimbStairsRecursive();
        System.out.println(solution.climbStairs(5)); // Output: 8
    }
}
