class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
       #   s.    m.    e 
       # [-4,-1,-1,0,1,2]
       # -4+(-1)+2 = -3
       # -1 + (-1) + 2 = 0. CORRECT
       # -1+1+0 = 0 CORRECT

       # case - []
       #add the empty list like that and return it

       #edge case - has numbers, but none add to zero
       #return empty list

       # edge case - full 0f zeros 
       #[[0,0,0]] 

       #base case 
       #if the nums length <= 3 empty list
       #APPROACH 1.
       #srtdnums = sorted(nums)

       #start = 0 
       #mid = (len(srtdnums)-1)//2
      #end = len(srtdnums) -1

       #while (start < mid and end > mid):
            # result = srtdnums[start] + srtdnums[mid] + srtdnums[end]
             #if(result == 0):
              #  result.append(srtdnums[start],srtdnums[mid],srtdnums[end])
             #elif(result>0):
              # start+=1
              # end-=1
    
            #start+=1
            #end-=
        result = []
        nums.sort()

        for i, a in enumerate(nums):
            if a > 0:
                break
            
            if i > 0 and a == nums[i-1]:
                continue
            
            start, end = i + 1, len(nums) - 1
            while start < end:
                threeSum = a + nums[start] + nums[end]
                if threeSum > 0:
                    end -= 1
                elif threeSum < 0:
                    start += 1
                else:
                    result.append([a, nums[start], nums[end]])
                    start += 1
                    end -= 1
                    while nums[start] == nums[start - 1] and start < end:
                        start+= 1

        return result 






        
