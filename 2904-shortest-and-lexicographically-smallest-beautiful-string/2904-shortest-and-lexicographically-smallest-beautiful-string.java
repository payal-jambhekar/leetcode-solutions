class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int ones = 0;
        String ans = "";

        for (int right = 0; right < s.length(); right++) {

            // Add current character
            if (s.charAt(right) == '1') {
                ones++;
            }

            // If we have more than k ones, shrink
            while (ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }

            // Remove unnecessary leading zeros
            while (ones == k && s.charAt(left) == '0') {
                left++;
            }

            // We found a substring containing exactly k ones
            if (ones == k) {
                String curr = s.substring(left, right + 1);

                // Choose shorter
                if (ans.equals("") || curr.length() < ans.length()) {
                    ans = curr;
                }
                // If same length, choose lexicographically smaller
                else if (curr.length() == ans.length() && curr.compareTo(ans) < 0) {
                    ans = curr;
                }
            }
        }

        return ans;
    }
}