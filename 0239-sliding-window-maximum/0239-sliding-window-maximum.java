class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k +1];
        
        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;

        for(int i =0 ; i< n ; i++){

            if(!dq.isEmpty() && dq.peekFirst() < i - k +1){
                dq.removeFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.removeLast();
            }

            dq.addLast(i);

            if(i >= k-1){
                ans[idx] = nums[dq.peekFirst()];
                idx++;
            }

        }
        return ans;
    }
}