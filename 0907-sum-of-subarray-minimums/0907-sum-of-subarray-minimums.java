class Solution {
    long MOD = (long) 1e9 + 7;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int nse[] = new int[n];
        int pse[] = new int[n];
        Stack<Integer> st = new Stack<>();

        // nse
        for(int i = n-1; i >=0; i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i] ){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();

            st.push(i);
        }
        st.clear();
         // pse
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i] ){
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();

            st.push(i);
        }

        long  ans =0;
        for(int i =0 ; i< n ; i++){
            long left = i-pse[i];
            long right = nse[i] - i;

            long contribution = (long) arr[i] *left*right;

            ans = (ans + contribution) % MOD;
        }
        return (int)ans;
    }
}