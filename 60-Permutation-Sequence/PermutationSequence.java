public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> numbers = new ArrayList<>();
        
        int fac = 1;
        for (int i =1; i<=n; i++){
            fac *= i;
            numbers.add(i);
        }
        
        k--;
        for (int i =0; i<n; i++){
            fac /= (n-i);
            int index = k / fac;
            sb.append(numbers.remove(index));
            k -= index*fac;
        }
        return sb.toString();
    }
}