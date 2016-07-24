public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        char sign = '+';
        while(i < s.length()){
            if(s.charAt(i) == ' ') {
                i++; 
                continue;//Do not forget continue here
            }
            int num = 0;
            while(i < s.length() && Character.isDigit(s.charAt(i))){
                    num = num*10 + s.charAt(i)-'0';
                    i++;
                }
            if(sign == '+') stack.push(num);
            if(sign=='-') stack.push(-num);
            if(sign == '*') stack.push(stack.pop()*num);
            if(sign == '/') stack.push(stack.pop()/num);
            if(i<s.length()) sign = s.charAt(i); //need to check if i is outofbound here
            i++;
        }
        int res = 0;
        for(int m: stack) res+=m;
        return res;
    }
}