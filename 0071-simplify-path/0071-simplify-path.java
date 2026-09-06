class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        StringBuilder result = new StringBuilder();
        String[] parts = path.split("/");

        for(String part : parts){
            if(part.equals("") || part.equals(".")){
                continue;
            }
            if(!st.isEmpty() && part.equals("..")){
                st.pop();
            }else if(!part.equals("..")){
                st.push(part);
            }
        }

        for(String dir : st){
            result.append("/").append(dir);
        }
        if(result.length() == 0){
            return "/";
        }

        return result.toString();
    }
}