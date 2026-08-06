class Solution {
    public int smallestNumber(int n, int t) {
       
        for(int i = n ; ;i++){
             int product =1;
             int num =i;
            while(num > 0){
                int digit = num % 10;
                product *= digit;
                num /= 10;
            }

            if(product % t == 0){
               return i;
            }
        }
    }
}