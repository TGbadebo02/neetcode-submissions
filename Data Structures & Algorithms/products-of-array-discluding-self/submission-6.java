class Solution {
    public int[] productExceptSelf(int[] nums) {
       if(nums.length == 0) return new int[0];

       int total = 1;
       int [] result = new int[nums.length];

       int prefix = 1;
       result[0] = prefix;

       for(int i = 0; i < nums.length - 1; i++){
           prefix *= nums[i];
           result[i + 1] = prefix;
       }
        
       int suffix = 1;
       for(int i = nums.length - 1; i > 0; i--){
        //i = 3.. i - 1 = 8
          suffix *= nums[i];
          result[i - 1] *= suffix;
          
       }

       return result;
    }
}  
