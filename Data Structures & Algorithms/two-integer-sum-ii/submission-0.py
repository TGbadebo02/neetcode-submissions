class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        result = []

        if(len(numbers) < 2):
          return result
        
        start = 0
        end = len(numbers) -1 
        sum = 0 
        
        
        while(start < end):
            sum = numbers[start] + numbers[end]
            
            if(sum>target):
               end-=1
            
            elif(sum < target):
               start+=1
           
            #sum = numbers[start] + numbers[end]

            else:
                return [start + 1,end +1]
        
       
        return result
