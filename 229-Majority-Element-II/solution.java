public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null) return res;
        
        int count1 =0, count2 = 0, major1 = 0, major2 = 1;
        
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == major1) count1++;
            else if(nums[i] == major2) count2++;
            else if(count1 == 0){
                major1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0){
                major2 = nums[i];
                count2 =1;
            }else{
                count1--;
                count2--;
            }
        }
        int c1 =0, c2=0;
        for(int n : nums){
            if(n == major1) c1++;
            else if(n == major2) c2++;  //do not forget else here
        }
        if(c1 > nums.length/3) res.add(major1);
        if(c2 > nums.length/3) res.add(major2);
        return res;
    }
}