class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '(' ){
                stack.push(ch);
            }else{
                if(ch == ')'){
                    if(stack.isEmpty()) return false;
                    if(stack.peek() == '(')
                        stack.pop();
                    else
                        return false;
                }
            }
            if(ch == '[' ){
                stack.push(ch);
            }else{
                if(ch == ']'){
                    if(stack.isEmpty()) return false;
                    if(stack.peek() == '[')
                        stack.pop();
                    else
                        return false;
                    }
            }
            if(ch == '{' ){
                stack.push(ch);
            }else{
                if(ch == '}'){
                    if(stack.isEmpty()) return false;
                    if(stack.peek() == '{')
                        stack.pop();
                    else
                        return false;
                }
            }
        }

        return stack.isEmpty();
    }
}