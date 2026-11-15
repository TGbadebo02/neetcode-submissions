class TrieNode{
    public HashMap<Character, TrieNode> children = new HashMap<>();
    public boolean isEndOfWord = false; 

    public TrieNode(){
        this.children = children;
        this.isEndOfWord = isEndOfWord;
    }
}
class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if(word == null) return;
        
        TrieNode cur = root;
        //c -> a -> t
        for(char c : word.toCharArray()){
            if(!cur.children.containsKey(c)){
                cur.children.put(c,new TrieNode());
            }
            cur = cur.children.get(c);
        }
        cur.isEndOfWord = true;
    }

    public boolean search(String word) {
        if(word == null) return true;

        TrieNode cur = root;

        for(char c : word.toCharArray()){
            if(!cur.children.containsKey(c)){
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
       if(prefix == null) return true;
       
       TrieNode cur = root;

       for(char c : prefix.toCharArray()){
          if(!cur.children.containsKey(c)){
            return false;
          }
          cur = cur.children.get(c);
       }
       
       return true;
    }
}
