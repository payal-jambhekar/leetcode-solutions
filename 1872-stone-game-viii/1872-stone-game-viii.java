class Solution {
    public int stoneGameVIII(int[] stones) {
     for (int i = 1; i < stones.length; i++) {
            stones[i] += stones[i - 1];
        }

        // Initially, take all stones
        int best = stones[stones.length - 1];

        // Work backwards
        for (int i = stones.length - 2; i >= 1; i--) {
            best = Math.max(best, stones[i] - best);
        }

        return best;
    }
}