public class Solution {
    public List<Integer> grayCode(int n) {
        //G(i) = i ^ (i/2);
        List<Integer> result = new LinkedList<>();
        for (int i =0; i < 1<<n;i++) result.add(i ^ i>>1);
        return result;
}
}