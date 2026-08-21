class Solution {

    public long findKthSmallest(int[] coins, int k) {
        long low = 1;
        long high = (long) Arrays.stream(coins).min().getAsInt() * k;

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long limit, int[] coins) {
        long ans = 0;
        int n = coins.length;

        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            int bits = 0;
            boolean valid = true;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    bits++;
                    lcm = lcm(lcm, coins[i], limit);
                    if (lcm > limit) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) continue;

            long cnt = limit / lcm;
            if ((bits & 1) == 1) {
                ans += cnt;
            } else {
                ans -= cnt;
            }
        }

        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private long lcm(long a, long b, long limit) {
        long g = gcd(a, b);
        a /= g;

        if (a > limit / b) {
            return limit + 1;
        }

        return a * b;
    }
}