public class Solution {
    private int index;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        
        HashMap<Integer, ArrayList<Integer>> map= new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++){
            if(map.containsKey(prerequisites[i][1])){
                map.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }else{
                ArrayList<Integer> l = new ArrayList<>();
                l.add(prerequisites[i][0]);
                map.put(prerequisites[i][1],l);
            }
        }
        
        int[] visited = new int[numCourses];
        index = numCourses;
        for(int i = 0; i < numCourses; i++){
            if(isCycle(map, visited, i, res)) return new int[0];
        }
        return res;
    }
    
    private boolean isCycle(HashMap<Integer, ArrayList<Integer>> map, int[] visited, int i, int[] res){
        if(visited[i] == 1) return false;
        if(visited[i] == -1) return true;
        
        visited[i] = -1;
        if(map.containsKey(i)){
            for(int j: map.get(i)){
                if(isCycle(map, visited, j, res)) return true;
            }
        }
        visited[i] =1;
        res[--index] = i;
        return false;
    }
}