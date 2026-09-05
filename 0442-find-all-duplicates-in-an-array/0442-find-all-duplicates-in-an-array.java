class Solution {
    public List<Integer> findDuplicates(int[] nums) {
       List<Integer> ans = new ArrayList<>();
       HashMap<Integer, Integer> map = new HashMap<>();

       for(int num : nums){
        map.put(num , map.getOrDefault(num , 0) +1);
       }

       for(int n : map.keySet()){
        if(map.get(n) == 2){
            ans.add(n);
        }
       }
       return ans;
    }
}