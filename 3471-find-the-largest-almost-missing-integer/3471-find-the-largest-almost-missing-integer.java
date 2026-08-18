class Solution {
    public int largestInteger(int[] nums, int k) {
       
        HashMap<Integer,Integer> map = new HashMap<>();

        int n = nums.length;

        for(int i =0; i <= n-k ; i++){
             HashSet<Integer> set = new HashSet<>();
             for(int j =i ; j < i+k; j++){
                set.add(nums[j]);
             }
             for(int num : set){
                map.put(num, map.getOrDefault(num , 0) +1);
             }
        }
        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            
            if(entry.getValue() == 1){

                ans= Math.max(ans , entry.getKey());
            }
        }
        return ans;
    }
}