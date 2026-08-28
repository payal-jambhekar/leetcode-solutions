class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();

        // Count characters
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Check if palindrome is possible
        int odd = 0;
        char mid = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                mid = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        // Build frequency of first half
        int halfLen = n / 2;
        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        // target's first half
        String targetHalf = target.substring(0, halfLen);

        /*
         * First check whether targetHalf itself can be formed.
         * If yes, construct that palindrome and check whether
         * it is strictly greater than target.
         */
        int[] temp = halfFreq.clone();

        boolean possibleEqual = true;

        for (int i = 0; i < halfLen; i++) {
            int c = targetHalf.charAt(i) - 'a';

            if (temp[c] == 0) {
                possibleEqual = false;
                break;
            }

            temp[c]--;
        }

        if (possibleEqual) {
            String candidate = buildPalindrome(targetHalf, mid, n);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        /*
         * We now need the smallest permutation of halfFreq
         * that is GREATER than targetHalf.
         *
         * Find the rightmost position where we can put a
         * character greater than target[i], while keeping
         * target[0...i-1] unchanged.
         */
        int[] remaining = halfFreq.clone();

        // Move from left to right, consuming target characters.
        // We store the remaining frequency after each prefix.
        int[][] states = new int[halfLen + 1][26];
        states[0] = remaining.clone();

        for (int i = 0; i < halfLen; i++) {
            int c = targetHalf.charAt(i) - 'a';

            if (states[i][c] == 0) {
                break;
            }

            states[i + 1] = states[i].clone();
            states[i + 1][c]--;
        }

        // Try pivot from right to left
        for (int i = halfLen - 1; i >= 0; i--) {

            // If target prefix up to i-1 cannot be formed,
            // no earlier pivot can work either.
            if (states[i] == null) {
                continue;
            }

            int targetChar = targetHalf.charAt(i) - 'a';

            // Find the smallest character greater than target[i]
            for (int c = targetChar + 1; c < 26; c++) {

                if (states[i][c] == 0) {
                    continue;
                }

                char[] resultHalf = new char[halfLen];

                // Copy target prefix
                for (int j = 0; j < i; j++) {
                    resultHalf[j] = targetHalf.charAt(j);
                }

                // Put the smallest greater character
                resultHalf[i] = (char) ('a' + c);

                int[] rest = states[i].clone();
                rest[c]--;

                // Fill the remaining positions with smallest chars
                int pos = i + 1;

                for (int x = 0; x < 26; x++) {
                    while (rest[x] > 0) {
                        resultHalf[pos++] = (char) ('a' + x);
                        rest[x]--;
                    }
                }

                String half = new String(resultHalf);

                return buildPalindrome(half, mid, n);
            }
        }

        return "";
    }

    private String buildPalindrome(String half, char mid, int n) {
        char[] result = new char[n];

        int h = half.length();

        // Left half
        for (int i = 0; i < h; i++) {
            result[i] = half.charAt(i);
        }

        // Middle
        if (n % 2 == 1) {
            result[h] = mid;
        }

        // Right half
        for (int i = 0; i < h; i++) {
            result[n - 1 - i] = half.charAt(i);
        }

        return new String(result);
      
    }
}