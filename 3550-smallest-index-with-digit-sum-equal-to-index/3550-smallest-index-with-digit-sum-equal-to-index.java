class Solution {
    public int smallestIndex(int[] nums) {
        
        int n = nums.length;
        int sum =0;

        for(int i=0;  i< n; i++){
            int num = nums[i];
            
            while(num !=0){

                int digit = num % 10;
                sum += digit;
                num /= 10;
            }

            if(sum == i){
                return i;
            }
            sum = 0;
        }
        return -1;
    }
}