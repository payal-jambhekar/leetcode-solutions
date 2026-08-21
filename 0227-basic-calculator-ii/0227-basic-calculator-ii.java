class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int num =0;
        char sign = '+'; 
        for(char ch : s.toCharArray()){

            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }else if(ch == '+'||ch == '-'||ch == '*'||ch == '/'){
                if( sign == '+'){
                    st.push(num);
                }else if(sign == '-'){
                    st.push(-num);
                }else if( sign == '*'){
                    st.push(st.pop() * num);
                }else if( sign == '/'){
                    st.push(st.pop() / num);
                }
            sign = ch ;
            num =0;
            }

        }
        if( sign == '+'){
                st.push(num);
        }else if(sign == '-'){
                st.push(-num);
        }else if( sign == '*'){
                st.push(st.pop() * num);
        }else if( sign == '/'){
                st.push(st.pop() / num);
        }

        int ans =0;
        while(!st.isEmpty()){
            ans+= st.pop();
        }
        return ans;
    }
}