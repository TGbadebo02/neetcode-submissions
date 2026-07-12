class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // set the base case.
        if (!wordList.contains(endWord))
            return 0;

        wordList.add(beginWord);
        int minLen = 1;
        Map<String, List<String>> map = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String ptrnWrd = word.substring(0,i) + "*" + word.substring(i + 1);
                map.computeIfAbsent(ptrnWrd, k -> new ArrayList<>()).add(word);
            }
        }

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visitedSet = new HashSet<>();
        queue.offer(beginWord);
        visitedSet.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String node = queue.poll();

                if (node.equals(endWord))
                    return minLen;

                for(int j = 0; j < node.length(); j++){
                   String pattern = node.substring(0,j) + '*' + node.substring(j+1);

                   for(String nghbr : map.getOrDefault(pattern, Collections.emptyList())){
                        
                        if(!visitedSet.contains(nghbr)){
                            visitedSet.add(nghbr);
                            queue.offer(nghbr);
                        }
                   }
                }
            }
            minLen++;
        }

        return 0;
    }
}
