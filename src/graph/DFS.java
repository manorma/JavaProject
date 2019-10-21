package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class DFSGraph{
    DFSGraph(ArrayList<ArrayList<Integer>> list,int src,int dest){
        list.get(src).add(dest);
        list.get(dest).add(src);
    }
}
public class DFS {

    private static void DFSUtil(ArrayList<ArrayList<Integer>> list,int v,boolean[] visited){
        visited[v] = true;
        System.out.print(v);
        ArrayList<Integer> l = list.get(v);
        for(Integer i:l){
            if(!visited[i]){
                DFSUtil(list,i,visited);
            }
        }


    }

     private static void traverseDFS(ArrayList<ArrayList<Integer>> list,boolean[] visibility){
         ArrayList<Integer> outer = list.get(0);
         for(Integer in : outer){
             if(!visibility[in]){
                 DFSUtil(list,in ,visibility);
             }
         }
         System.out.println();
         

     }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> vertice = new ArrayList<>();
        while (t-- > 0){
            int eov = sc.nextInt();

            for(int i =0;i<eov;i++){
                int u = sc.nextInt();
                int v= sc.nextInt();
                if(!vertice.contains(u)){
                    vertice.add(u);
                }
                if(!vertice.contains(v)){
                    vertice.add(v);
                }
                new DFSGraph(list,u,v);

            }
            boolean[] visibility = new boolean[1001];
            traverseDFS(list,visibility);

        }



    }
}
