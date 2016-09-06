/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int helper(char[] cc, int idx, NestedInteger res){
        NestedInteger ret = null; // for storing the list element
        Integer num=null; // for storing the number element
        int sign = 1; // sign of the number
        while ( idx < cc.length && cc[idx] != ']') { // parsing between [ and ]
            char c = cc[idx++];
            if ( c == '[' ) { // start parsing a list by calling helper function
                ret = new NestedInteger();
                idx = helper(cc, idx, ret); // idx is the next index after ]
            } else if ( c == ',' ){  // time to add a element to the list
                if (ret != null) { // it is a List element
                    res.add(ret);
                } else { // it is a integer or null
                    if (num != null) res.add(new NestedInteger( sign*num ) );
                }
                ret = null;  // reset 
                num = null;
                sign = 1;
            } else if ( c == '-' ){ // sign of the number
                sign = -1;
            } else { // calculate the number
                num = num == null ? (int)(c-'0'): (num*10) + (int)(c-'0');
            }
        }
        if (ret != null) { // add the last element or the element before ]
            res.add(ret);
        } else {
            if (num != null) res.add(new NestedInteger(sign*num));
        }
        return idx+1; // very important!!! return the next index 
    }
    
    public NestedInteger deserialize(String s) {
        NestedInteger ret = new NestedInteger(); // a dummy root element
        helper(s.toCharArray(), 0, ret);
        return ret.getList().get(0); // return a element in the dummy root
    }
}