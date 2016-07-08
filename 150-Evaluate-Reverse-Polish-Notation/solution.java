public class Solution {
    public int evalRPN(String[] tokens) {
        int a, b;
        if(tokens == null || tokens.length == 0) return -1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++){
            if (tokens[i].equals("+")){
                stack.add(stack.pop()+stack.pop());
            }else if (tokens[i].equals("-")){  //should not use "=="
                b = stack.pop();
                a = stack.pop();
                stack.add(a-b);
            }else if (tokens[i].equals("*")){
                b = stack.pop();
                a = stack.pop();
                stack.add(a*b);
            }else if (tokens[i].equals("/")){
                b = stack.pop();
                a = stack.pop();
                stack.add(a/b);
            }else{
                stack.add(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}