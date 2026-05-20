class Solution:

    def encode(self, strs: List[str]) -> str:
        encodeStr = ""
        for word in strs:
            length = len(word)
            encodeStr += str(length) + "#" + word
        return encodeStr

    def decode(self, s: str) -> List[str]:
        result, i = [], 0 
        
        #iterate through the encode string
        while i < len(s):
            #this is to find the length before the delimiter.
         j = i
         while s[j]!= '#':
            j += 1
         length = int(s[i:j])
         result.append(s[j + 1: j + 1 + length])
         i = j + 1 + length
        
        return result
