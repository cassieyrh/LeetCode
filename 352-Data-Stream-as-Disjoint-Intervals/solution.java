/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {

    /** Initialize your data structure here. */
    TreeMap<Integer, Interval> map;       //key is the start of the Interval
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if(map.containsKey(val)) return;
        Integer h = map.higherKey(val);         //use Integer type so that it can compare with null
        Integer l = map.lowerKey(val);
        if(h != null && l != null && map.get(l).end == val -1 && h == val + 1){
            map.get(l).end = map.get(h).end;
            map.remove(h);
        }else if(l != null && map.get(l).end + 1 >= val){
            map.get(l).end = Math.max(val, map.get(l).end);
        }else if( h != null && val == h - 1){
            map.put(val, new Interval(val, map.get(h).end));
            map.remove(h);
        }else map.put(val, new Interval(val, val));
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<Interval>(map.values());
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */