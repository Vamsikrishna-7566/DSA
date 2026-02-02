/**
 * Frog Jump - Space Optimized Tabulation
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class FrogJumpSpaceOptimized {

    public int frogJump(int[] heights) {
        int n = heights.length;

        int prev = 0;
        int beforePrev = 0;

        for (int i = 1; i < n; i++) {
            int left = prev + Math.abs(heights[i] - heights[i - 1]);

            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = beforePrev + Math.abs(heights[i] - heights[i - 2]);
            }

            int current = Math.min(left, right);

            beforePrev = prev;
            prev = current;
        }

        return prev;
    }

    public static void main(String[] args) {
        FrogJumpSpaceOptimized solution = new FrogJumpSpaceOptimized();
        int[] heights = {10, 20, 30, 10};
        System.out.println(solution.frogJump(heights));
    }
}
