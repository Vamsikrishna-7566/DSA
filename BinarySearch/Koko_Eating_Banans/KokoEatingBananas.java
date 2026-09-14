// Koko Eating Bananas — binary search on the answer.
// Assumes positive piles and h >= piles.length.
// Time: O(n * log m), space: O(1), m = maximum pile size.
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxValue = 0;
        for (int pile : piles) {
            maxValue = Math.max(maxValue, pile);
        }

        if (piles.length == h) {
            return maxValue;
        }

        int low = 1;
        int high = maxValue;
        int result = maxValue;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long hoursCount = bananaToEat(piles, mid);

            if (hoursCount <= h) {
                result = mid; // Save a feasible speed.
                high = mid - 1; // Try a slower speed.
            } else {
                low = mid + 1; // A faster speed is needed.
            }
        }
        return result;
    }

    public long bananaToEat(int[] piles, int speed) {
        long totalHours = 0;
        for (int pile : piles) {
            // Cast before addition to prevent int overflow.
            totalHours += (pile + (long) speed - 1) / speed;
        }
        return totalHours;
    }
}
