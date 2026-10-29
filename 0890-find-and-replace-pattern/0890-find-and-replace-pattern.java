class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
       List<String> list = new ArrayList<>();

       for(String word : words){

            HashMap<Character , Character> map1 = new HashMap<>();
            HashMap<Character , Character> map2 = new HashMap<>();
            boolean match = true;

            for(int i=0; i< pattern.length(); i++){

                char w = word.charAt(i);
                char p= pattern.charAt(i);

                if(map1.containsKey(p) && map1.get(p) != w){
                    match = false;
                    break;
                }

                if(map2.containsKey(w) && map2.get(w) != p){
                    match = false;
                    break;
                }   
                map1.put(p , w);
                map2.put(w ,p);
            }
            if(match){
                list.add(word);
            }
       }
        return list;
    }
}