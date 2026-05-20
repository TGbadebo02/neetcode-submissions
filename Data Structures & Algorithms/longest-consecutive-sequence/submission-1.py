class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        #take count of the consecutive sequence.
        counter = 0; 
        set_nums = list(set(nums))
        

    #iterate through nums, with nested loop. time complex - 'O(n^2)'.
       # for i in range(len(set_nums)):
          #  for j in range(len(set_nums)):
            #    if set_nums[j]- set_nums[i]==1:
             #    counter+=1 
    #Approach 2 - 
        for n in nums:
            #checks for previous nghbr.
            if(n-1) not in set_nums:
               length = 0
               #checks for next nghbr.
               while(n + length) in set_nums:
                 length += 1
                #return the length of the consecutive sequence.
               counter = max(length,counter)
        return counter
         
         #Time complexity is 'O(n)', only iterating through the list once
         #Space complexity is 'O(n)', additional space to check for neighbours
         # where 'n' is the size of the input array.
