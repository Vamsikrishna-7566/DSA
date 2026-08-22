import java.util.Arrays;

/**
 * LeetCode 567: Permutation in String.
 *
 * Pattern: Fixed-size sliding window.
 *
 * Given two lowercase English strings, determine whether s2 contains a
 * contiguous substring that is a permutation of s1.
 *
 * Example:
 *   s1 = "ab", s2 = "eidbaooo" -> true
 *   s1 = "ab", s2 = "eidboaoo" -> false
 *
 * Time complexity: O(n), where n is the length of s2.
 * Space complexity: O(1), because both frequency arrays contain 26 elements.
 */
class Solution {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] targetFrequency = new int[26];
        int[] windowFrequency = new int[26];

        // Count the characters in s1 and the first window of s2.
        for (int i = 0; i < s1.length(); i++) {
            targetFrequency[s1.charAt(i) - 'a']++;
            windowFrequency[s2.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = s1.length() - 1;

        while (right < s2.length()) {
            if (Arrays.equals(targetFrequency, windowFrequency)) {
                return true;
            }

            // Remove the character leaving the current window.
            windowFrequency[s2.charAt(left) - 'a']--;

            left++;
            right++;

            // Add the character entering the next window, if one exists.
            if (right < s2.length()) {
                windowFrequency[s2.charAt(right) - 'a']++;
            }
        }

        return false;
    }
}
