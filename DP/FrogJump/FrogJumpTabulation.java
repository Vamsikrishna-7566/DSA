/**
 * Frog Jump - Tabulation (Bottom-Up DP)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class FrogJumpTabulation {

    public int frogJump(int[] heights) {
        int n = heights.length;
        int[] tab = new int[n];

        for (int i = 1; i < n; i++) {
            int left = tab[i - 1] + Math.abs(heights[i] - heights[i - 1]);

            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = tab[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            }

            tab[i] = Math.min(left, right);
        }

        return tab[n - 1];
    }

    public static void main(String[] args) {
        FrogJumpTabulation solution = new FrogJumpTabulation();
        int[] heights = {10, 20, 30, 10};
        System.out.println(solution.frogJump(heights));
    }
}
