# Maximum Points You Can Obtain from Cards

## Problem

You are given an integer array `cardPoints` and an integer `k`.

In one step, you can take one card from either the beginning or the end of the array. Return the maximum score obtainable after taking exactly `k` cards.

## Key Observation

The selected cards must be a combination of:

- Some cards from the beginning.
- The remaining cards from the end.

If `x` cards are taken from the left, then `k - x` cards must be taken from the right. Therefore, there are only `k + 1` possible combinations.

## Approach: Sliding Window over the Selected Cards

1. Initially take all `k` cards from the left and calculate their sum.
2. Save this sum as the current maximum.
3. Move from right to left through those selected left-side cards:
   - Remove one selected card from the left side.
   - Add one card from the right end of the array.
   - Update the maximum score.
4. After all replacements, every possible left/right combination has been evaluated.

The combinations checked are:

- `k` from the left and `0` from the right.
- `k - 1` from the left and `1` from the right.
- `k - 2` from the left and `2` from the right.
- ...
- `0` from the left and `k` from the right.

## Example

```text
cardPoints = [1, 2, 3, 4, 5, 6, 1]
k = 3
```

Start with the first three cards:

```text
1 + 2 + 3 = 6
```

Then replace one left-side card at a time:

| Cards taken from left | Cards taken from right | Score |
|---:|---:|---:|
| 3 | 0 | `1 + 2 + 3 = 6` |
| 2 | 1 | `1 + 2 + 1 = 4` |
| 1 | 2 | `1 + 6 + 1 = 8` |
| 0 | 3 | `5 + 6 + 1 = 12` |

The maximum score is `12`.

## Why It Works

Every valid selection contains a prefix from the left and a suffix from the right whose total number of cards is `k`. The algorithm begins with the full left prefix and repeatedly exchanges one left card for the next right card. This generates all `k + 1` valid distributions exactly once, so the largest recorded sum is the correct answer.

## Java Solution

```java
class Solution {

    public int maxScore(int[] cardPoints, int k) {
        int right = cardPoints.length - 1;
        int currentScore = 0;

        for (int i = 0; i < k; i++) {
            currentScore += cardPoints[i];
        }

        int maxScore = currentScore;

        for (int i = k - 1; i >= 0; i--) {
            currentScore -= cardPoints[i];
            currentScore += cardPoints[right];

            maxScore = Math.max(maxScore, currentScore);
            right--;
        }

        return maxScore;
    }
}
```

## Complexity Analysis

- **Time complexity: `O(k)`**
  - Calculating the first sum takes `O(k)`.
  - Replacing the selected cards takes another `O(k)`.
  - Therefore, the total is `O(2k)`, which simplifies to `O(k)`.
  - Because `k <= n`, it can also be described as `O(n)` in the worst case.

- **Space complexity: `O(1)`**
  - The algorithm uses only a few integer variables.
  - No extra data structure grows with the input size.

## Notes About the Original Solution

The original logic is correct. The cleaned-up version makes two small readability improvements:

- The first loop starts at index `0`, which makes it clearer that the first `k` cards are being selected.
- `sum` and `maxSum` are renamed to `currentScore` and `maxScore` to better describe their roles.

