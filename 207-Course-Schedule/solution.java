public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        if(numCourses == 0 || len == 0) return true;
        
        int[] indegree = new int[numCourses];
        for(int i = 0; i < len; i++){
            indegree[prerequisites[i][0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<numCourses; i++){
            if(indegree[i] == 0) queue.offer(i);
        }
        
        int numNode = queue.size();
        
        while(!queue.isEmpty()){
            int course = queue.remove();
            for(int i = 0 ; i< len; i++){
                if (course == prerequisites[i][1]){
                    indegree[prerequisites[i][0]]--;
                    if(indegree[prerequisites[i][0]] == 0){
                        numNode++;
                        queue.offer(prerequisites[i][0]);
                    }
                }
            }
        }

        return numNode == numCourses;
        
    }
}