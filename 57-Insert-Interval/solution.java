/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        if(intervals.size() == 0){
            res.add(newInterval);
            return res;
        }
        int i = 0;
        for(Interval interval : intervals){
            if(interval.end < newInterval.start){
                res.add(interval);
                i++;
                continue;
            }
            if(interval.start > newInterval.end){
                break;
            }
            newInterval.start = Math.min(newInterval.start,interval.start);
            newInterval.end = Math.max(newInterval.end, interval.end);
            i++;
        }
        res.add(newInterval);
        while(i < intervals.size()) res.add(intervals.get(i++));
        return res;
    }
}