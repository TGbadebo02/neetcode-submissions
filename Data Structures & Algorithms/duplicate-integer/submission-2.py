class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
     #Approach 1. Brute force search.
        #base case if the list is empty.
        #if not nums:
          #  return False
        #base case if the list is just 1 element long.
        #if len(nums) == 1:
          #  return False
        
        #Average case 
        #for i in range(len(nums) - 1):
        # for j in range(i + 1, len(nums)):
         #  if nums[i]==nums[j]:
          #  return True
        #return False
    
     #Approach 2. Hashset
      hashSet = set()

      for n in nums:
       if n in hashSet:
        return True
       hashSet.add(n)
      return False

    
    