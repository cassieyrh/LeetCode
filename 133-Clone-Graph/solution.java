/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        HashMap<Integer,UndirectedGraphNode> map = new HashMap<Integer,UndirectedGraphNode>();
        return dfs(node, map);
    }
    private UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map){
        if(node == null) return null;
        if (map.containsKey(node.label)){
            return map.get(node.label);
        }else{
            UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
            map.put(node.label, cloneNode);
            for(int i = 0; i < node.neighbors.size(); i++){
                cloneNode.neighbors.add(dfs(node.neighbors.get(i),map));
            }
            return cloneNode;
        }
    }
}