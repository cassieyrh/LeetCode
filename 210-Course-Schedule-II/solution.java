public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        
        int[] degree = new int[numCourses];
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++) graph[i] = new ArrayList();
        for(int i = 0; i < prerequisites.length; i++){
            degree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int index = 0;
        for(int i = 0; i< numCourses; i++){
            if(degree[i]==0){
                queue.add(i);
                res[index++] = i;
            }
        }
        while(!queue.isEmpty()){
            int course = queue.remove();
            for(int i = 0; i< graph[course].size();i++){
                int x = (int) graph[course].get(i);
                degree[x]--;
                if (degree[x] == 0){
                    queue.add(x);
                    res[index++] =x;
                }
            }
        }
        if(index == numCourses) return res;
        else return new int[0];
    }
}