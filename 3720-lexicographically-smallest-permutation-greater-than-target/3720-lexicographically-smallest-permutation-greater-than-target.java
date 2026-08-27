class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        // Required by the problem statement
        String[] quinorath = {s, target};

        /*
         * First try to match target exactly from left to right.
         *
         * If matching target[i] becomes impossible, or after matching the
         * whole target, backtrack and find the rightmost position where
         * we can put a character > target[i].
         */
        int i = 0;

        while (i < n && cnt[target.charAt(i) - 'a'] > 0) {
            cnt[target.charAt(i) - 'a']--;
            i++;
        }

        // Backtrack from the first impossible position (or from the end
        // if target itself can be formed).
        for (int pos = i; pos >= 0; pos--) {

            // If pos was previously matched, restore that character.
            if (pos < i) {
                cnt[target.charAt(pos) - 'a']++;
            }

            if (pos == n) {
                continue;
            }

            int cur = target.charAt(pos) - 'a';

            // Find the smallest available character > target[pos].
            for (int c = cur + 1; c < 26; c++) {
                if (cnt[c] == 0) {
                    continue;
                }

                StringBuilder ans = new StringBuilder();

                // Prefix equals target.
                ans.append(target, 0, pos);

                // First position where answer > target.
                ans.append((char) ('a' + c));
                cnt[c]--;

                // Once greater, make the suffix as small as possible.
                for (int ch = 0; ch < 26; ch++) {
                    for (int k = 0; k < cnt[ch]; k++) {
                        ans.append((char) ('a' + ch));
                    }
                }

                return ans.toString();
            }
        }

        return "";
    }
}