
public class WordDictionary {
    public class TrieNode{
        boolean isEnd;
        TrieNode[] links = new TrieNode[26];
        TrieNode(){
            
        }
    }

    private TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(curr.links[ch - 'a'] == null){
                curr.links[ch-'a'] = new TrieNode();
            } 
            curr = curr.links[ch-'a'];
        }
        curr.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return findword(word, root,0);
    }
    
    private boolean findword(String word, TrieNode node, int index){
        if(index == word.length()){
            return node.isEnd;
        }
        char ch = word.charAt(index);
        if(ch != '.') {
            return node.links[ch -'a'] != null && findword(word, node.links[ch -'a'], index+1);
        }else{
            for(int i = 0; i< 26; i++){
                if(node.links[i] != null){
                    if(findword(word, node.links[i], index+1)) return true;
                }
            } 
        }
        return false;
    }
    
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");