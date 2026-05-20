class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        sDict = {}
        tDict = {}

        for ltr in s:
            if ltr in sDict:
              sDict[ltr]+=1
            else:
              sDict[ltr]=1
        
        for ltr in  t:
            if ltr in tDict:
                tDict[ltr]+=1
            else:
                tDict[ltr]=1
        
        return sDict == tDict
        