class Solution {
    public boolean isSameAfterReversals(int num) {
        int n = num;

        int rev =0;
        while(num > 0){
            int digit = num % 10;
             rev = (rev * 10) + digit;
            num /= 10;
        }
        int rev1 =0;
        while(rev > 0){
            int digit = rev % 10;
             rev1 = (rev1 * 10) + digit;
            rev /= 10;
        }

        return (n == rev1) ? true :false;
        
    }
}