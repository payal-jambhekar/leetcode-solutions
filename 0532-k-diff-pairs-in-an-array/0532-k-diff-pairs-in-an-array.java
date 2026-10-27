class Solution {
    public int findPairs(int[] nums, int k) {
        
        HashSet<String> set = new HashSet<>();

        for(int i = 0 ; i < nums.length; i++){
            
            for(int j = i+ 1; j< nums.length ; j++){
                if(nums[i] - nums[j] == k || nums[j] - nums[i] == k){
                    String pair = Math.min(nums[i], nums[j]) + "-" + Math.max(nums[i], nums[j]);
                    set.add(pair);
                }
            }
        }
        return set.size();
    }
}