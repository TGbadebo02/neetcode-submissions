class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        
        for(int i = 1; i <= n; i++){
           
            int num = i;
            int oneCount = 0;

            while(num > 0){

                if(num % 2 == 1) oneCount++;

                num /= 2; 
            }

            result[i] = oneCount;
        }

        return result;
    }
}
