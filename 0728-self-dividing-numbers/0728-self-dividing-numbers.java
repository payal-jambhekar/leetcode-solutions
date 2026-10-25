class Solution {
    private boolean check(int num) {
        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            temp /= 10;
        }
        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = left; i <= right; i++) {
            if (check(i)){
                list.add(i);
            }
        }
        return list;
    }
}