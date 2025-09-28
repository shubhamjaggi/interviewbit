public class Solution {
    public int solve(int A, int[][] B) {
        // create adjacency list
        List<List<Node>> adj = new ArrayList<>();
        for(int i=0; i<A; i++) adj.add(new ArrayList<>());
        for(int[] edge:B) {
            adj.get(edge[0]-1).add(new Node(edge[1]-1,edge[2])); // -1 because nodes are 1 to n
            adj.get(edge[1]-1).add(new Node(edge[0]-1,edge[2])); // undirected graph > so, add bothways
        }
        
        boolean[] vis = new boolean[A];
        int totCost=0;
        
        Queue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::cost));
        pq.add(new Node(0,0));
        
        while(!pq.isEmpty()) {
            Node curr=pq.poll();
            int u=curr.val;
            
            if(vis[u]) continue;
            vis[u]=true;
            
            totCost+=curr.cost;
            
            for(Node nei:adj.get(u)) {
                int v=nei.val;
                int cost=nei.cost;  
                pq.add(new Node(v,cost));
            }
        }
        
        return totCost;
    }
    
}

class Node {
    int val;
    int cost;
    
    Node(int val, int cost) {
        this.val=val;
        this.cost=cost;
    }
    
    int cost() { return this.cost; }
}