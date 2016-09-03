public class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int left = Integer.MAX_VALUE, down = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE, up = Integer.MIN_VALUE;
        
        Map<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < rectangles.length; i++) {
            left = Math.min(left, rectangles[i][0]);
            down = Math.min(down, rectangles[i][1]); 
            right = Math.max(right, rectangles[i][2]);
            up = Math.max(up, rectangles[i][3]);
            if (!helper(map, rectangles[i][0], rectangles[i][1], 1)) return false;
            if (!helper(map, rectangles[i][2], rectangles[i][1], 2)) return false;
            if (!helper(map, rectangles[i][2], rectangles[i][3], 4)) return false;
            if (!helper(map, rectangles[i][0], rectangles[i][3], 8)) return false;
        }
        
        for (Integer x : map.keySet()) {
            for (Integer y : map.get(x).keySet()) {
                Integer v = map.get(x).get(y);
                if ((x == left || x == right) && (y == up || y == down)) {
                    if (v != 1 && v != 2 && v != 4 && v != 8) return false;
                } else {
                    if (v != 3 && v != 6 && v != 9 && v != 12 && v != 15) return false;
                }
            }
        }
        
        return true;
    }
    private boolean helper(Map<Integer, HashMap<Integer, Integer>> map, int x, int y, int pos) {
        if (!map.containsKey(x)) map.put(x, new HashMap<>());
        if (!map.get(x).containsKey(y)) map.get(x).put(y, 0);
        if ((map.get(x).get(y) & pos) != 0) return false;
        map.get(x).put(y, map.get(x).get(y) | pos);
        
        return true;
    }
}