class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum =0;


        for(int i =1; i <=n ; i++){
            int square = 1;
            if(n % i == 0){
            
                square = square * nums[i-1] * nums[i-1];
                sum += square;
            }
        }

        return sum;
    }
}