class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> set = new HashMap<>();

        for(char ch : s.toCharArray()){
            set.put(ch , set.getOrDefault(ch , 0) + 1);
        }

        for(char ch : t.toCharArray()){

            if(set.getOrDefault(ch, 0) == 0){
                return ch;
            }

            set.put(ch , set.get(ch) - 1);
        }
    return ' ';
    }
}