/* IMPORTANT: Multiple classes and nested static classes are supported */
package graphs;
/* Problem Description: https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/prison-break-5/description/
 * Alfie was a prisoner in mythland. Though Alfie was a witty and intelligent guy.He was confident of escaping prison.After few days of observation,He figured out that the prison consists of (N×N) cells.i.e The shape of prison was (N×N) matrix. Few of the cells of the prison contained motion detectors.So Alfie planned that while escaping the prison he will avoid those cells containing motion detectors.Yet before executing his plan,Alfie wants to know the total number of unique possible paths which he can take to escape the prison.Initially Alfie is in cell (1,1) while the exit of the cell (N,N).

note:->Alfie can move in all four direction{ if his current location is (X,Y), he can move to either 
(X+1,Y), (X−1,Y), (X,Y+1), (X,Y−1) }. If the first cell (1,1) and the last cell(N,N) contain motion detectors,then Alfie can't break out of the prison.

INPUT:

The first line contain number of test cases "T". T test cases follow.The first line of each test case contains an integer "N",(i.e the size of the (N×N) matrix).The next n lines contain N space separated values either 0 or 1."1" represents a cell containing motion detectors.

OUTPUT:

output total number of unique possible paths which he can take to escape the prison.

Constraint:

1≤T≤20
1≤N≤20

Sample Input
3
4
0 1 1 0 
0 0 1 0 
0 0 0 0 
0 1 1 0 
4
0 0 0 1 
0 0 0 0 
1 1 1 0 
1 0 0 0 
4
0 1 1 0 
0 0 1 1 
0 0 0 0 
0 1 0 0

Sample Output
2
4
4
 * */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class PrisonBreak {
	static boolean[][] visited;
    public static void main(String args[] ) throws Exception {


        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);

        int N;
        int [][] grid;
        for (int t = 0; t < T; t++) {
            N=Integer.parseInt(br.readLine());
            grid=new int[N][N];
            
            for(int i=0;i<N;i++){
                StringTokenizer st=new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    grid[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            visited=new boolean[N][N];
            if(grid[0][0]==1 && grid[N-1][N-1]==1){
                System.out.println(0);
            }else{
                long ans=totalPaths(grid,0,0,-1,-1,N-1);
                System.out.println(ans);
            }
        }

    }
    
    public static long totalPaths(int[][] grid, int i, int j,int prev_i,int prev_j, int N){
        if(i==N && j==N)
            return 1l;
        if(i<0 || i>N || j<0 || j>N)
            return 0;
        if(visited[i][j]){
        	return 0;
        }
        if(grid[i][j]==1){
        	if(i==0 && j==0){
        		//do nothing
        	}else
        	return 0;
        }
        visited[i][j]=true;
        long totalPath=totalPaths(grid,i+1,j,i,j,N)+totalPaths(grid,i-1,j,i,j,N)+totalPaths(grid,i,j+1,i,j,N)+totalPaths(grid,i,j-1,i,j,N);
        visited[i][j]=false;
        return totalPath;
    }
}
