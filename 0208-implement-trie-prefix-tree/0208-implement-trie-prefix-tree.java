class Trie {
    public class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public int getIndex(char letter){
        return letter-'a';
    }

    public void insert(String word) {
        TrieNode node = root; 
        for(char c : word.toCharArray()){
            if(node.children[getIndex(c)] == null){
                node.children[getIndex(c)] = new TrieNode();
            }
            node = node.children[getIndex(c)];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray()){
            if(node.children[getIndex(c)]==null){
                return false;
            }
            node = node.children[getIndex(c)];
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
         TrieNode node = root;
        for(char c : prefix.toCharArray()){
            if(node.children[getIndex(c)]==null){
                return false;
            }
            node = node.children[getIndex(c)];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */