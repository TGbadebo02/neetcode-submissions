public class TrieNode {
    public HashMap<Character, TrieNode> children = new HashMap<>();
    public boolean isEnd = false;

    public TrieNode() {
        this.children = children;
        this.isEnd = isEnd;
    }
}

class PrefixTree {
    public TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null)
            return;

        TrieNode cur = root;
        // so iterate through the root node children.
        for (char c : word.toCharArray()) {
            if (!cur.children.containsKey(c)) {
                cur.children.put(c, new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isEnd = true;
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
        return cur.isEnd;
    }

    public boolean startsWith(String prefix) {
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
