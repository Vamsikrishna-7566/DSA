/**
 * Daily Temperatures using a monotonic stack of indexes.
 * Time: O(n). Auxiliary space: O(n). Output space: O(n).
 * LeetCode-compatible Solution class.
 */
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            // Resolve earlier days for which today is warmer.
            while (!stack.isEmpty()
                    && temperatures[i] > temperatures[stack.peek()]) {
                int previousDay = stack.pop();
                result[previousDay] = i - previousDay;
            }
            // Today now waits for a future warmer day.
            stack.push(i);
        }
        return result;
    }
}
