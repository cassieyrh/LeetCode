class TrieNode {
    // Initialize your data structure here.
    private TrieNode[] links;
    private final int R = 26;
    public TrieNode() {
        links = new TrieNode[R];
    }
    private boolean isEnd;
    
    public boolean containsKey(char cha){
        return links[cha - 'a'] != null;
    }
    
    public TrieNode get(char cha){
        return links[cha - 'a'];
    }
    
    public void put(char cha, TrieNode node){
        links[cha - 'a'] = node;
    }
    
    public void setEnd(){
        isEnd = true;
    }
    
    public boolean isEnd(){
        return isEnd;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char curr = word.charAt(i);
            if (!node.containsKey(curr)){
                node.put(curr, new TrieNode());
            }
            node = node.get(curr);
        }
        node.setEnd();
    }
    
    public TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(int i = 0; i<word.length();i++){
            char curr = word.charAt(i);
            if (!node.containsKey(curr)){
                return null;
            }
            node = node.get(curr);
        }
        return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node!= null;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");