class Solution {
    public int maxArea(int[] heights) {
        
        int left = 0;
        int right = heights.length - 1;
        int maxSum = 0;

            while(left < right){
                
                int length = right - left;
               
                int area = length * Math.min(heights[right],heights[left]);
                maxSum = Math.max(maxSum, area);
                
                if(heights[left] < heights[right]){
                   left++;
                }else{
                    right--;
                }
            }

            return maxSum;
    }
}
