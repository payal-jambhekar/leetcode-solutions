class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        List<String> ans = new ArrayList<>();

        int n = s.length();

        for(int i =0; i<= n -10; i++){
            String seq = s.substring(i , i+10);

            if(!seen.contains(seq)){
                seen.add(seq);
            }else{
               if (!ans.contains(seq)) {
                     ans.add(seq);
                }
            }
        }
        return ans;
    }
}