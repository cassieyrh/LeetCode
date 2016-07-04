class WordNode{
    String word;
    int steps;
    public WordNode(String word, int steps){
        this.word = word;
        this.steps = steps;
    }
}

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        LinkedList<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(beginWord, 1));
        wordList.add(endWord);
        
        while(!queue.isEmpty()){
            WordNode cur = queue.remove();
            String word = cur.word;
            
            if (word.equals(endWord)){
                return cur.steps;
            }
            
            char[] arr = word.toCharArray();
            for (int i = 0; i<arr.length; i++){
                for (char c = 'a'; c <='z'; c++){
                    if (arr[i] == c) continue;
                    char temp = arr[i];
                    arr[i]=c;
                    
                    String neighber = new String(arr);
                    if (wordList.contains(neighber)){
                        queue.add(new WordNode(neighber, cur.steps+1));
                        wordList.remove(neighber);
                    }
                    arr[i] = temp; // do not forget the reset
                }
            }
        }
        return 0;
    }
}