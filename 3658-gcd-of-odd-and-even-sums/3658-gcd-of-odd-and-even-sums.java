class Solution {
    public int gcdOfOddEvenSums(int n) {
        
        int OddSum =0;
        int EvenSum =0;
        int even =2;
        int odd =1;
        int i =0;

        while(i < n){
            EvenSum += even;
            OddSum += odd;
            even +=2;
            odd +=2 ;  
            i++;
        }

        return getGCD(EvenSum , OddSum);
    }

    int getGCD(int a , int b){

        while( b != 0){
            int valOfb = b;
            b = a % b;
            a = valOfb;
        }

        int ans = a;
        return ans;
    }
}