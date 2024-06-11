class Solution {
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        public TrieNode(){
            children = new TrieNode[26];
            isWord =false;
        }
    }
    class Trie{
        private TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public int getIndex(char letter){
            return letter - 'a';
        }

        public void insert(String word){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                if(node.children[getIndex(c)] == null){
                    node.children[getIndex(c)] = new TrieNode();
                }
                node = node.children[getIndex(c)];
            }
            node.isWord = true;
        } 

        public String getRoot(String word){
            TrieNode node = root;
            StringBuilder cWord = new StringBuilder();
            for(char c : word.toCharArray()){
                if(node.children[getIndex(c)] == null){
                   break;
                }
                cWord.append(c);
                node = node.children[getIndex(c)];
                if(node.isWord){
                    return cWord.toString();
                }
            }
            return word;
        }
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for(String word : dictionary){
            trie.insert(word);
        }

        String[] words = sentence.split(" ");
        StringBuilder  result = new StringBuilder("");
        for(String word : words){
            result.append(trie.getRoot(word)).append(" ");
        }
    return result.toString().trim();
    }
}