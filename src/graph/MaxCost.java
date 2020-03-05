package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MaxCost {

    int findMaxCostIndex(long cost[],boolean set[],int V){
        int index = -1;
        long max = Integer.MIN_VALUE;
        //System.out.println();
        for(int v=0;v<V;v++){
            //System.out.print(cost[v]+" ");
            if(set[v] == false && cost[v] > max){
                max = cost[v];
                index = v;
            }
        }
        return index;
    }

    long findMaxCost(int[][] graph,int src,int V){
        long cost[] = new long[V];
        boolean set[] = new boolean[V];
        int u = -1;

        for(int i=0;i<V;i++){
            cost[i] = Integer.MIN_VALUE;
            set[i] = false;
        }

        cost[src] = 0;
        for(int c=0;c<V;c++){
            u = findMaxCostIndex(cost,set,V);

            if(u== -1){
                return -1;
            }
            set[u]= true;


            //System.out.println();
            for(int v=0;v<V;v++){
                if(set[v] == false && graph[u][v] != 0 && cost[u]+graph[u][v] >= cost[v]){
                    cost[v] = cost[u]+graph[u][v];
                    //System.out.print(cost[v]+" ");
                }
            }
        }
        return cost[u];
    }
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MaxCost obj = new MaxCost();
        int t = Integer.parseInt(br.readLine());
        int[][] grapgh;
        while(t-- > 0){
            String line = br.readLine();
            String[] input = line.split(" ");
            int V = Integer.parseInt(input[0]);
            grapgh = new int[V][V];
            int p = Integer.parseInt(input[1]);
            while(p-- > 0){
                String line1 = br.readLine();
                String[] input1 = line1.split(" ");
                int i = Integer.parseInt(input1[0]);
                int j = Integer.parseInt(input1[1]);
                int c = Integer.parseInt(input1[2]);
                grapgh[i-1][j-1]= c;
                grapgh[j-1][i-1] = c;
            }
            long out = obj.findMaxCost(grapgh,0,V);
            System.out.print(out+"\n");
        }


    }
}
