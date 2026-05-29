class Solution {
    public int hammingWeight(int n) {
        
        int oneCount = 0;

        for(int i = 0; i < 32; i++){
            oneCount += n & 1;
            n = n >> 1;
        }
        
        return oneCount;
    }
}
