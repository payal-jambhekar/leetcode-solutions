class Solution {
    public int primePalindrome(int n) {

        // Small special cases
        if (n <= 2) return 2;
        if (n <= 3) return 3;
        if (n <= 5) return 5;
        if (n <= 7) return 7;
        if (n <= 11) return 11;

        // Generate odd-length palindromes
        for (int half = 1; ; half++) {

            int palindrome = makePalindrome(half);

            if (palindrome >= n && isPrime(palindrome)) {
                return palindrome;
            }
        }
    }

    // Creates an odd-length palindrome
    private int makePalindrome(int half) {

        int result = half;
        int temp = half / 10;

        while (temp > 0) {
            result = result * 10 + temp % 10;
            temp /= 10;
        }

        return result;
    }

    // Checks whether a number is prime
    private boolean isPrime(int num) {

        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}