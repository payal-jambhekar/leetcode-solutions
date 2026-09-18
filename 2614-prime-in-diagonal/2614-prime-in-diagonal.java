class Solution {
    public int diagonalPrime(int[][] nums) {
        
        int n = nums.length;
        int[] result = new int[2 * n];

        int k =0;

        for(int i =0; i< n; i++){
            //Primary  diagonal

            result[k++] = nums[i][i];

            //Secondary diagonal

            result[k++] = nums[i][n-1-i];
        }

        int maxPrime = 0;
        for(int i=0; i< result.length ; i++){   

            boolean isPrime = true;

            if(result[i] < 2){
                isPrime = false;
            }

            for(int j =2; j*j <= result[i]; j++){
                if( result[i] % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                maxPrime = Math.max(maxPrime , result[i]);
            }
        }

        return maxPrime;
    }
}