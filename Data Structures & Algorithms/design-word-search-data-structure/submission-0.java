class TrieNode {
    public HashMap<Character, TrieNode> children = new HashMap<>();
    public boolean endOfWord = false;

    public TrieNode() {
        this.children = children;
        this.endOfWord = false;
    }
}

class WordDictionary {
    public TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if (word.isEmpty())
            return;

        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }

        cur.endOfWord = true;
    }

    public boolean search(String word) {
        if (word.isEmpty())
            return true;

        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, TrieNode node) {
        TrieNode cur = node;

        for (int i = j; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                for (TrieNode child : cur.children.values()) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (cur.children.get(c) == null) {
                    return false;
                }
                cur = cur.children.get(c);
            }
        }
        return cur.endOfWord;
    }
}
