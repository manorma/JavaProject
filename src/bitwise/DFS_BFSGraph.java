package bitwise;

import java.util.*;

class Graph {
    int v;
    ArrayList<Integer> adj[];
    Graph(int v){
        this.v =v;
        adj = new ArrayList[v];
        for (int i =0 ;i<v ;i++){
            adj[i] = new ArrayList<>();
        }
    }

    protected void addEdge(int u ,int v){
        adj[u].add(v);
    }
}

public class DFS_BFSGraph {
    private static Graph g;

    //Application -  Detection cycle in graph ,finding path between two vertices
    private static void DFSUtil(int u,boolean[] visited){
        visited[u] = true;
        System.out.print(u);
        Iterator<Integer> iterator = g.adj[u].iterator() ;
        iterator.forEachRemaining(n -> {
            if(!visited[n]){
                DFSUtil(n,visited);
            }
        });

    }

    private static void DFS(int s){
        boolean[] visited = new boolean[g.v];
        System.out.println("DFS is :");
        DFSUtil(s,visited);
    }

    //Application - GPS navigation system  , Peer to peer network ,l

    private static void BFS(int s){
        boolean[] visited = new boolean[g.v];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        System.out.println("BFS : ");
        while (queue.size() > 0){
            int n = queue.poll();
            System.out.print(n);
            Iterator<Integer> i = g.adj[n].iterator();
            while (i.hasNext()){
                int e = i.next();
                if(!visited[e]){
                    queue.add(e);
                    visited[e]= true;
                }
            }
        }

    }


    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();

        while(t-- > 0){
            int v = sc.nextInt();
            int s = sc.nextInt();
            g = new Graph(v);
            g.addEdge(0,1);
            g.addEdge(0,2);
            g.addEdge(1,2);
            g.addEdge(2,0);
            g.addEdge(2,3);
            g.addEdge(3,3);
            BFS(s);
            DFS(s);
        }
    }
}
