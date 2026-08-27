class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0) +1);
        }
        int ans = 0;
        boolean oddCnt = false;
        for(int freq : map.values()){

            if( freq % 2 == 0 ){
                ans += freq;
            }else{
                ans += freq -1;
                oddCnt = true;
            }
        }

        if(oddCnt){
            ans += 1;
        }

        return ans;
    }
}