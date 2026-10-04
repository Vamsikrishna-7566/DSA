class Solution {
    public int minOperations(String s) {
        int mismatch = 0;

        for (int i = 0; i < s.length(); i++) {
            // The pattern starting with 0 has 0 at even indices.
            char expected = (i % 2 == 0) ? '0' : '1';

            if (s.charAt(i) != expected) {
                mismatch++;
            }
        }

        // Matching one pattern means mismatching the other.
        int oppositeMismatch = s.length() - mismatch;
        return Math.min(mismatch, oppositeMismatch);
    }
}
