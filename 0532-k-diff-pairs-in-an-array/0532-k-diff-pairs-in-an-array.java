class Solution {
    public int findPairs(int[] nums, int k) {
        
        //HashSet<String> set = new HashSet<>();

        // for(int i = 0 ; i < nums.length; i++){
            
        //     for(int j = i+ 1; j< nums.length ; j++){
        //         if(nums[i] - nums[j] == k || nums[j] - nums[i] == k){
        //             String pair = Math.min(nums[i], nums[j]) + "-" + Math.max(nums[i], nums[j]);
        //             set.add(pair);
        //         }
        //     }
        // }
        // return set.size();


        if (k < 0) return 0;

        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> pairs = new HashSet<>();

        for (int num : nums) {
            if (visited.contains(num - k)) {
                pairs.add(num);
            }

            if (visited.contains(num + k)) {
                pairs.add(num + k);
            }

            visited.add(num);
        }

        return pairs.size();

    }
}