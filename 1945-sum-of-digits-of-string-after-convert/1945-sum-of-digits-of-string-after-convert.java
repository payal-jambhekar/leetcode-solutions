class Solution {
    public int getLucky(String s, int k) {

        StringBuilder str = new StringBuilder();

        // Convert each character to its alphabet value
        for (char ch : s.toCharArray()) {
            int value = ch - 'a' + 1;
            str.append(value);
        }

        // First digit-sum transformation
        int ans = 0;

        for (int i = 0; i < str.length(); i++) {
            ans += str.charAt(i) - '0';
        }

        // Remaining k - 1 transformations
        for (int i = 1; i < k; i++) {

            int sum = 0;

            while (ans != 0) {
                int digit = ans % 10;
                sum += digit;
                ans /= 10;
            }

            ans = sum;
        }

        return ans;
    }
}