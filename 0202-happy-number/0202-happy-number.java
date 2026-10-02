class Solution {
    public boolean isHappy(int n) {
        
        int fast = n;
        int slow = n;

        do{
            slow= squareNum(slow);
            fast = squareNum(squareNum(fast));

        }while(fast != slow);

        if(slow == 1){
            return true;
        }
        return false;
    }
    private int squareNum(int n){
        int sum =0;
        while(n>0){
            int digit = n %10;
            sum += digit * digit;
            n/=10;
        }
        return sum;
    }
}