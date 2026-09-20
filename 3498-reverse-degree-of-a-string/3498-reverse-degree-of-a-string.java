class Solution {
    public int reverseDegree(String s) {

        int sum =0;

        for(int i=0; i< s.length() ; i++){

            char ch = s.charAt(i);

            int position = i + 1;

            int value = 'z' - ch + 1;

            sum = sum + (position * value);

        }
        return sum;

    }
}