class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1000000007;
        int n = s.length();

        // dp[i] = number of distinct subsequences
        // using first i characters, including empty subsequence
        long[] dp = new long[n + 1];

        dp[0] = 1; // empty subsequence

        // Stores the last dp value when each character appeared
        long[] last = new long[26];

        for (int i = 1; i <= n; i++) {
            char ch = s.charAt(i - 1);
            int index = ch - 'a';

            // Every existing subsequence can either take or skip
            // the current character
            dp[i] = (2 * dp[i - 1]) % MOD;

            // Remove duplicates created by previous occurrence
            dp[i] = (dp[i] - last[index] + MOD) % MOD;

            // Current value becomes the latest occurrence
            last[index] = dp[i - 1];
        }

        // Remove empty subsequence
        return (int) ((dp[n] - 1 + MOD) % MOD);
    }
}