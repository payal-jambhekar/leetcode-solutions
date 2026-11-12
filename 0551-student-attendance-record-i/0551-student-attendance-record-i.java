class Solution {
    public boolean checkRecord(String s) {
        int cntA = 0;
        int cntL = 0;

        for(char ch : s.toCharArray()){

            if(ch == 'A'){
                cntA++;

                if(cntA >=2) return false;
            }
            if(ch == 'L'){
                cntL++;

                if(cntL >= 3) return false;
            }else{
                cntL = 0;
            }
        }

      return true;
    }
}