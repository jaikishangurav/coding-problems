package dynamicProgramming;

import java.util.ArrayList;

public class UniquePathsInAGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//recursive approach without DP
	public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> a) {
	    int m=a.size();
	    int n=a.get(0).size();
	    return totalPaths(a,0,0,m,n);
	}
	private int totalPaths(ArrayList<ArrayList<Integer>> a, int i, int j,int m, int n){
	    if(i==m-1 && j==n-1 && a.get(i).get(j)!=1)
	        return 1;
	    if(i>=m || j>=n || a.get(i).get(j)==1)
	        return 0;
	    return totalPaths(a,i,j+1,m,n)+totalPaths(a,i+1,j,m,n);     
	}

}
