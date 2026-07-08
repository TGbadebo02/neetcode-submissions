class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // set the base case.
        if (!wordList.contains(endWord))
            return 0;

        Map<String, List<String>> map = new HashMap<>();
        wordList.add(beginWord);
        for (String word : wordList) {
            for (int j = 0; j < word.length(); j++) {
                String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                map.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Set<String> visit = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        int result = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                if (word.equals(endWord)) return result;

                for (int j = 0; j < word.length(); j++) {
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);

                    for (String nghbr : map.getOrDefault(pattern, Collections.emptyList())) {
                        if (!visit.contains(nghbr)) {
                            visit.add(nghbr);
                            queue.offer(nghbr);
                        }
                    }
                }
            }
            result++;
        }
        return 0;
    }
}
