public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0, Sum = 0, start = 0;
        for (int i = 0; i < gas.length; i++){
             curSum += (gas[i] - cost[i]);
             Sum += (gas[i] - cost[i]);
             if(curSum < 0){
                 start = i+1;
                 curSum = 0;
             }
        }
        if(Sum < 0) return -1;
        return start;
    }
}