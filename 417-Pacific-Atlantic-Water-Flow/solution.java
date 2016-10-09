public class Solution {
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new ArrayList<>();
        if(matrix.length == 0) return res;
        int m = matrix.length, n = matrix[0].length;
        Stack<int[]> stack = new Stack<>();
        Set<List<Integer>> pacific = new HashSet<>();
        Set<List<Integer>> atlantic = new HashSet<>();
        boolean[][] visited = new boolean[m][n]; 
        for(int i = 0; i < m; i++){
            stack.push(new int[]{i,0});
            pacific.add(Arrays.asList(i,0));
            visited[i][0] = true;
        }
        for(int j = 0; j < n; j++){
            stack.push(new int[]{0,j});
            pacific.add(Arrays.asList(0,j));
            visited[0][j] = true;
        }
        
        int[][] dir = new int[][] {{0,1},{0,-1},{-1,0},{1,0}};
        
        while(!stack.isEmpty()){
            int[] pos = stack.pop();
            for(int i = 0; i < 4; i++){
                int x = pos[0] + dir[i][0];
                int y = pos[1] + dir[i][1];
                if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y]){
                   continue;
                } 
                
                if(matrix[x][y] >= matrix[pos[0]][pos[1]]){
                    stack.push(new int[]{x,y});
                    pacific.add(Arrays.asList(x,y));
                    visited[x][y] = true;
                }
            }
        }
        
        stack.clear();
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            atlantic.add(Arrays.asList(i,n-1));
            stack.push(new int[]{i,n-1});
            visited[i][n-1] = true;
        }
        for(int j = 0; j < n; j++){
            stack.push(new int[]{m-1,j});
            atlantic.add(Arrays.asList(m-1,j));
            visited[m-1][j] = true;
        }
    
        while(!stack.isEmpty()){
            int[] pos = stack.pop();
            for(int i = 0; i < 4; i++){
                int x = pos[0] + dir[i][0];
                int y = pos[1] + dir[i][1];
                if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y]){
                   continue;
                } 
                
                if(matrix[x][y] >= matrix[pos[0]][pos[1]]){
                    stack.push(new int[]{x,y});
                    atlantic.add(Arrays.asList(x,y));
                    visited[x][y] = true;
                }
            }
        }
        for(List<Integer> cur : pacific){
            
            if(atlantic.contains(cur)){
                int[] arr = new int[2];
                arr[0] = cur.get(0);
                arr[1] = cur.get(1);
                res.add(arr);
            } 
        }
        return res;
    }
}