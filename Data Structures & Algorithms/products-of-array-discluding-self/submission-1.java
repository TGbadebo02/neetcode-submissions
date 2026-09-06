class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 1 || nums.length > 100000) return new int[0];

        int [] result = new int[nums.length];
 
        for(int i = 0; i < nums.length; i++){
            int sum = 1;
            for(int j = 0; j < nums.length; j++){
               if(j != i){
                  sum *= nums[j];
               }
            }
            result[i] = sum;
        }

        return result;
    }
}  
