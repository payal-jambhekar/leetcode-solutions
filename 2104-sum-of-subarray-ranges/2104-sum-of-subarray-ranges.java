class Solution {
    public long subArrayRanges(int[] nums) {

         return sumOfMax(nums) - sumOfMin(nums);
    }

    long sumOfMax(int[] nums){
        int n = nums.length;
        int[] nge = new int[n];
        int[] pge = new int[n];

        Stack<Integer> s = new Stack<>();

        // next greater element

        for(int i = n-1; i >=0 ; i--){
            while(!s.isEmpty() && nums[s.peek()] <= nums[i]){
                s.pop();
            }

            nge[i] = s.isEmpty() ? n: s.peek();

            s.push(i);
        }
        s.clear();
        // previous greater element

        for(int i = 0; i< n ; i++){
            while(!s.isEmpty() && nums[s.peek()] < nums[i]){
                s.pop();
            }

            pge[i] = s.isEmpty() ? -1 : s.peek();

            s.push(i);
        }

        long maxSum =0;

        for(int i=0 ; i< n ; i++){
            long left = i - pge[i];
            long right = nge[i] -i;

            maxSum += (long) nums[i] * left * right;
           
        }
        return  maxSum;
    }

    long sumOfMin(int[] nums){
        int n = nums.length;
        int[] nse = new int[n];
        int[] pse = new int[n];

        Stack<Integer> s = new Stack<>();

        // nse

        for(int i = n-1; i>=0 ; i--){
            while(!s.isEmpty() && nums[s.peek()] >= nums[i]){
                s.pop();
            }

            nse[i] = s.isEmpty()? n : s.peek();

            s.push(i);
        }
        s.clear();
         // pse

        for(int i = 0; i < n ; i++){
            while(!s.isEmpty() && nums[s.peek()] > nums[i]){
                s.pop();
            }

            pse[i] = s.isEmpty()? -1 : s.peek();

            s.push(i);
        }

        long minSum =0;

        for(int i=0; i< n ;i++){
            long left = i - pse[i];
            long right = nse[i] - i;

            minSum += (long) nums[i] * left * right;

           
        }

        return minSum;
    }
}