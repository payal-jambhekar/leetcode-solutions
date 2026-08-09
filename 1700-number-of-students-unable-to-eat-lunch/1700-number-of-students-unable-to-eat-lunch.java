class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new ArrayDeque<>();

        for(int student : students){
            q.offer(student);
        }

        int sandwichIndex =0;
        int rotation =0;

        while(!q.isEmpty() && rotation < q.size()){
            if(q.peek() == sandwiches[sandwichIndex]){
                q.poll();
                sandwichIndex++;
                rotation = 0;
            }else{
                int student = q.poll();
                q.offer(student);
                rotation++;
            }
        }
        return q.size();
    }
}