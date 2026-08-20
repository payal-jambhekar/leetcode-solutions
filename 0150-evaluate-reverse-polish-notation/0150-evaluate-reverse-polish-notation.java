class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int n = tokens.length;
        int i =0 , ans;
        while(i < n){
            if(tokens[i].equals("+") ||tokens[i].equals("-") ||tokens[i].equals("*") ||tokens[i].equals("/")){
                int b = st.pop();
                int a= st.pop();
                if(tokens[i].equals("+")){
                     ans = a + b;
                }else if(tokens[i].equals("-")){
                    ans = a-b;
                }else if(tokens[i].equals("*")){
                    ans = a*b;
                }else{
                    ans = a/b;
                }
                st.push(ans);
            }
            else{
                st.push(Integer.parseInt(tokens[i]));
            }
            i++;
        }
        return st.peek();
    }
}