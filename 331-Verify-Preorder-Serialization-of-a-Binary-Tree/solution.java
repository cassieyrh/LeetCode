public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null) return false;
        String[] str = preorder.split(",");
        Stack<String> stack = new Stack<>();
        for(String s: str){
            while(s.equals("#") && !stack.isEmpty() && stack.peek().equals("#")){
                stack.pop();
                if(stack.isEmpty()) return false;
                stack.pop();
            }
            stack.push(s);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
}