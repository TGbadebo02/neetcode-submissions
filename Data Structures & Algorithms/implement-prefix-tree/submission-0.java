class TrieNode {
    public HashMap<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;

    public TrieNode() {
        this.children = children;
        this.endOfWord = endOfWord;
    }
}

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        // base case.
        if (word == null)
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
        if (word == null)
            return true;

        TrieNode cur = root;

        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }

        return cur.endOfWord;
    }

    public boolean startsWith(String prefix) {
        // base case.
        if (prefix == null)
            return true;

        TrieNode cur = root;

        for (char c : prefix.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                return false;
            }

            cur = cur.children.get(c);
        }

        return true;
    }
}
