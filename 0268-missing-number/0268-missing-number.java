class Solution {
    public int missingNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        int ans = 0;
        for(int num : nums){
            set.add(num);
        }

        for(int i =0; i <= n ; i++){

            if(!set.contains(i)){
             ans = i;
            }
        }
        return ans;
    }
}