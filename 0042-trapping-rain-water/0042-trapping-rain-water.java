class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for(int i =1 ; i<= n-1; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[n-1] = height[n-1];
        for(int i =n-2; i>=0; i--){
            rightMax[i] = Math.max(rightMax[i+1] , height[i]);
        }

        int total =0;
        for(int i =0 ; i <=n-1; i++){
            if(height[i] < leftMax[i] && height[i] < rightMax[i]){
                total += Math.min(leftMax[i], rightMax[i])- height[i];
            }
        }
        return total;
    }
}