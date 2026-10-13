class Solution {

    public int countPrimes(int n) {

        if (n <= 1) {
            return 0;
        }

        int count = 0;

        boolean[] isprime = new boolean[n];

        Arrays.fill(isprime, true);

        //traverse untill sqrt(n)
        for (int i = 2; i * i < n; i++) {

            if (isprime[i] == true) {

                // i's multiples can't be a prime number
                for (int j = i * i; j < n; j = j + i) {

                    isprime[j] = false;

                }

            }

        }

        //counting prime
        for (int i = 2; i < n; i++) {

            if (isprime[i] == true) {

                count++;

            }

        }

        return count;

    }

}

