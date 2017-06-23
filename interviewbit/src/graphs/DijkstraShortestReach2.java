package graphs;

import java.util.Arrays;
import java.util.Scanner;

public class DijkstraShortestReach2 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[][] graph;
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int m = in.nextInt();
            graph=new int[n][n];
            for(int[] row:graph){
                Arrays.fill(row,0);
            }
            for(int a1 = 0; a1 < m; a1++){
                int x = in.nextInt();
                int y = in.nextInt();
                int r = in.nextInt();
                graph[x-1][y-1]=graph[y-1][x-1]=r;
            }
            //display(graph,n);
            int s = in.nextInt();
            dijkstras(graph, s-1, n);
        }
    }
    
    public static void dijkstras(int[][] graph, int src, int V){
        int[] dist=new int[V];
        boolean[] sptSet=new boolean[V];
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src]=0;
        for (int count = 0; count < V-1; count++){
            int u = minDistance(dist, sptSet,V);
            //System.out.println("minDist:"+u);
            sptSet[u] = true;
            for (int v = 0; v < V; v++){
                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }
        }
        for(int i=0;i<V;i++){
            if(i!=src){
                System.out.print(dist[i]+" ");
            }
        }
    }
    
    public static int minDistance(int dist[], boolean sptSet[],int V)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index=-1;
 
        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
 
        return min_index;
    }
    
    public static void display(int[][] graph,int n){
    	for(int i=0;i<n;i++){
    		for(int j=0;j<n;j++){
    			System.out.print(graph[i][j]+" ");
    		}
    		System.out.println();
    	}
    }
}
