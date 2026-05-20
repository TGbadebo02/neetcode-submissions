class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        #compact way of adding a list to the Dict(Hashmap), this helps us check if a list is 
        #already there or not.
        res = defaultdict(list)
        #loop through list 'strs', checking each string 's'.
        for s in strs:
            # a list of 26 elements, because there's 26 alphabets.
            count = [0] * 26
            #loop through 's' the string and check each character.
            for c in s:
                #if the char has been seen increment, if not keep going.
                count[ord(c) - ord('a')] += 1
                #convert count to tuple because of hash and add the s with, the current count.
            res[tuple(count)].append(s)
            #returns the list with sublist of anagrams.
        return list(res.values())

    #Time complexity - O(m * n), where m is num of strings and n is length of longest string
    #Space complexity - O(m)