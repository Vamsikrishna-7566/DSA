class Solution {

    public int maxScore(int[] cardPoints, int k) {
        int right = cardPoints.length - 1;
        int currentScore = 0;

        // Start by taking all k cards from the left.
        for (int i = 0; i < k; i++) {
            currentScore += cardPoints[i];
        }

        int maxScore = currentScore;

        // Replace one left-side card at a time with a right-side card.
        for (int i = k - 1; i >= 0; i--) {
            currentScore -= cardPoints[i];
            currentScore += cardPoints[right];

            maxScore = Math.max(maxScore, currentScore);
            right--;
        }

        return maxScore;
    }
}

