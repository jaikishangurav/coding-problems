package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BFSShortestReach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr= new Scanner(System.in);
        int q=sr.nextInt();
        for(int i=0;i<q;i++){
            int nodes=sr.nextInt();
            int edges=sr.nextInt();
            Map<Integer,List<Integer>> adjList=new HashMap<>();
            for(int j=0;j<edges;j++){
                int src=sr.nextInt();
                int dest=sr.nextInt();
                if (adjList.get(src) == null)
                    {
                        List<Integer> neighbours = new ArrayList<Integer>();
                        neighbours.add(dest);
                        adjList.put(src, neighbours);
                    } else
                    {
                        List<Integer> neighbours = adjList.get(src);
                        neighbours.add(dest);
                        adjList.put(src, neighbours);
                    }


                    if (adjList.get(dest) == null)
                    {
                        List<Integer> neighbours = new ArrayList<Integer>();
                        neighbours.add(src);
                        adjList.put(dest, neighbours);
                    } else
                    {
                        List<Integer> neighbours = adjList.get(dest);
                        neighbours.add(src);
                        adjList.put(dest, neighbours);
                    }
            }
            int start=sr.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start);
            int[] costs=new int[nodes+1];
            Arrays.fill(costs, 0);
            costs[start] = 0;
            Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
            while(!queue.isEmpty()){
            	int node=queue.remove();
            	if(visited.get(node)!=null)
            		continue;
            	visited.put(node, 1);
            	int nodeCost=costs[node];
            	List<Integer> children = adjList.get(node);
            	if(children!=null){
            		for(Integer child:children){
            			int total=nodeCost+6;
            			int key=child;
            			if(visited.get(key)==null){
            				queue.add(child);
            				if(costs[child]==0){
            					costs[child]=total;            					
            				}else if (costs[child] > total){
                                costs[child] = total;
                            }
            			}
            		}
            	}
            }
            for(int k=1;k<=nodes;k++){
            	if(k==start)
            		continue;
            	System.out.print(costs[k]==0?-1:costs[k]);
            	System.out.print(" ");
            }
            System.out.println();
        }
	}

}
