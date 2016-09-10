public class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                if(!stack.isEmpty()){
                    if(s.charAt(stack.peek()) == '(') stack.pop();
                    else stack.push(i);
                }else stack.push(i);
            }
        }
        if(stack.isEmpty()) return n;
        int longest = 0;
        int r = n, l = 0;
        while(!stack.isEmpty()){
            l = stack.pop();
            longest = Math.max(longest, r - l - 1);
            r = l;
        }
        longest = Math.max(longest, l);
        return longest;
    }
}