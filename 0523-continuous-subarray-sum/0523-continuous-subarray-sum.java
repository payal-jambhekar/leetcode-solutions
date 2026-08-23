class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();;

        map.put(0,-1);
        int currentPrefix =0;
        for(int num =0 ; num < nums.length; num++){
            currentPrefix += nums[num];

            int remainder = currentPrefix % k;
            if(map.containsKey(remainder)){
                if(num - map.get(remainder) >= 2){
                    return true;
                }
            }else{
                    map.put(remainder,num);
            }

        }

        return false;
    }

}