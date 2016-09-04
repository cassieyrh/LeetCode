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
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1) return intervals;
        List<Interval> res = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval in1, Interval in2){
                return Integer.compare(in1.start, in2.start);
            }
        });
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval interval: intervals){
            if(interval.start > end) {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }else{
                if(interval.end <= end) continue;
                else end = interval.end;
            }
        }
        res.add(new Interval(start, end));
        return res;
    }
}