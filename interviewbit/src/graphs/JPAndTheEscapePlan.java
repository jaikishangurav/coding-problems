package graphs;
import java.util.ArrayList;
/* Problem Statement:
 * JP is stuck in a grid of buildings of size 
N×M, after he is dropped from a helicopter. He will be able to escape this grid if he can reach to any building that is on the boundary of grid. 
He can jump from one building to the other if and only if : 
1.The buildings shares the edges with each other, i.e are adjacent (not diagonally adjacent)
2.The building to which he is jumping should be of the same height of the building on which he is standing OR the building to which he is jumping should have height at max J less than the one on which he is standing. 
The top left building will have the co-ordinates(1,1) and the bottom right will have the co-ordinates (N,M)
Input:
The first line contains two space separated integers N and M. Each of the next N lines contains M space separated integers denoting the heights of the buildings.
Next line contains three space separated integers Dx, Dy and J. Dx, Dy are the co-ordinates of the building where JP is dropped.

Output:
On the first line, print "YES"(without quotes) if he can reach any building on the boundary of the grid else print "NO"(without quotes).
If the answer is YES, on the next line print a single integer K, the length of the path JP must travel along to reach his destination. 
In each of the next K lines, print 22 space separated integers(x,y). It is necessary that the first co-ordinate along the path must be (Dx,Dy), and the last co-ordinate along the path must be present on the boundary of the grid.

A path is considered to the valid if and only if it does not contain any repeated co-ordinates, and does not violate any rules of JP's travel conditions mentioned above. 
In the case of printing a wrong path, you shall get a Wrong Answer. It is not necessary that the printed path should be the shortest one available.

Constraints:
1≤N,M≤500
1≤Height(i,j)≤109
1≤Dx≤N
1≤Dy≤M
1≤j≤10^9

Sample Input					Sample Output
1								YES
4 4								3
1 2 3 4							3 3
5 6 7 8							2 3
9 10 11 12						1 3
13 14 15 16
3 3 5
 * */

import java.util.Scanner;

public class JPAndTheEscapePlan {
	static int[][] grid;
    static boolean[][] visited;
    static ArrayList<Node> result;
    static int m;
    static int n;
    static int jump;
    public static void main(String args[] ) throws Exception {

    	 Scanner sr = new Scanner(System.in);
         int T = sr.nextInt();
         for(int t=0;t<T;t++){
     		n=sr.nextInt();
     		m=sr.nextInt();
     	    grid=new int[n][m];
     		for(int i=0;i<n;i++)
     		    for(int j=0;j<m;j++)
     		        grid[i][j]=sr.nextInt();
     		int dx=sr.nextInt();
     		int dy=sr.nextInt();
     		dx--;
     		dy--;
     		jump=sr.nextInt();
     		visited=new boolean[n][m];
     		visited[dx][dy]=true;
     		result=new ArrayList<>();
     		if(isBoundary(dx,dy) || dfs(dx,dy,dx+1,dy) || dfs(dx,dy,dx-1,dy) || dfs(dx,dy,dx,dy+1) || dfs(dx,dy,dx,dy-1))
     		{
     			result.add(new Node(dx,dy));
     			System.out.println("YES");
     		    System.out.println(result.size());
     		    printPath(result);
     		}else{
     			System.out.println("NO");
     		}     		
         }
     }
    
    public static boolean isBoundary(int i,int j){
    	if(i==0 || j==0 || i==n-1 || j==m-1)
    		return true;
    	return false;
    }
     
     private static boolean dfs(int old_i, int old_j,int i, int j){
         if(i<0 || i>n || j<0 || j>m)
             return false;
         if(grid[old_i][old_j]<grid[i][j] || grid[old_i][old_j]-grid[i][j]>jump)
        	 return false;
         if(visited[i][j])
        	 return false;
         if(i==0 || j==0 || i==n || j==m){
        	 result.add(new Node(i,j));
             return true;
         }
         visited[i][j]=true;
         
         if(dfs(i,j,i+1,j) || dfs(i,j,i-1,j) || dfs(i,j,i,j+1) || dfs(i,j,i,j-1)){
        	 result.add(new Node(i,j));
        	 return true;
         }
         return false;
    }
     
     private static void printPath(ArrayList<Node> result){
    	 for(int i=result.size()-1;i>=0;i--){
    		 Node n=result.get(i);
    		 System.out.println(n.x+1+" "+(n.y+1));
    	 }
     }
}

class Node{
	int x;
	int y;
	
	public Node(int x,int y){
		this.x=x;
		this.y=y;
	}
}
