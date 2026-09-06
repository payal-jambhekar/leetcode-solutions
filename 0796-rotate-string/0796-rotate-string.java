class Solution {
    public boolean rotateString(String s, String goal) {
        String ans = s;

        if (s.length() != goal.length()) {
            return false;
        }

        for(int i=0; i<s.length() ; i++){
            ans = ans.substring(1)+ans.substring(0 , 1);
            
            if(ans.equals(goal)){
                return true;
            }

        }
        return false;
    }
}