class Solution {
    public int minLengthAfterRemovals(String s) {
        Stack<Integer> st = new Stack<>();
        int count_a =0;
        int count_b = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'a'){
                count_a++;
            }else{
                count_b++;
            }
        }
        return Math.abs(count_a - count_b);
    }
}