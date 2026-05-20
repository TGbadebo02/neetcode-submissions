class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
    # output = 1
     result = [1] * (len(nums))
     prefix = 1
     for i in range(len(nums)):
        result[i] = prefix
        prefix *= nums[i]
     postfix = 1
     for i in range(len(nums) -1, -1, -1):
        result[i] *= postfix
        postfix *= nums[i]
     return result

     # COMPLEXITY ANALYSIS ->
     # - Time Complexity -> operation of the result list is 'O(n)'
     # - the two loops are 'O(n)' ...
     # - it's O(n) + O(n) + O(n) = 'O(n)'
     # - Space complexity -> the size of the result list is 'O(n)'
     # - theres also other operations like the postfix and prefix, which is 'O(1)'
     # - but overall the Space complexity is 'O(n)'.
        

     #APROACH 1!!!! ->
     #for i in nums:
       # output*=nums[i]
       # for j in nums:
       #     result[i] = output/nums[j]

     
    