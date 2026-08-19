class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Build bitmask for each row (only seats 2-9 matter)
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            if (col >= 2 && col <= 9) {
                map.put(row, map.getOrDefault(row, 0) | (1 << (col - 2)));
            }
        }

        int ans = (n - map.size()) * 2;

        int leftMask = 0b00001111;   // seats 2-5
        int midMask = 0b00111100;    // seats 4-7
        int rightMask = 0b11110000;  // seats 6-9

        for (int mask : map.values()) {
            boolean left = (mask & leftMask) == 0;
            boolean mid = (mask & midMask) == 0;
            boolean right = (mask & rightMask) == 0;

            if (left && right) {
                ans += 2;
            } else if (left || mid || right) {
                ans += 1;
            }
        }

        return ans;
    }
}