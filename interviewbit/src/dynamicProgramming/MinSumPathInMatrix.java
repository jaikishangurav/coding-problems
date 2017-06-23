package dynamicProgramming;
/*Problem statement:https://www.interviewbit.com/problems/min-sum-path-in-matrix/
 * 
 * */
import java.util.ArrayList;

public class MinSumPathInMatrix {
	int m;
    int n;
	public static void main(String[] args) {
		Integer[][] matrix=new Integer[][]{{1,3,2},{4,3,1},{5,6,1}};
		ArrayList<ArrayList<Integer>> input=new ArrayList<>();
		for(int i=0;i<matrix.length;i++){
			ArrayList<Integer> temp=new ArrayList<>();
			for(int j=0;j<matrix[0].length;j++){
				temp.add(matrix[i][j]);
			}
			input.add(temp);
		}
		int minPath=new MinSumPathInMatrix().minPathSum(input);
		System.out.println("Minimum sum path in matrix:"+minPath);
	}
	
	//Non Recursive approach
	public int minPathSum(ArrayList<ArrayList<Integer>> a) {
	    int m=a.size();
	    int n=a.get(0).size();
	    int[][] dp=new int [m][n];
	    for(int i=0;i<m;i++){
	        dp[i][0]=a.get(i).get(0);
	        if(i>0){
	            dp[i][0]+=dp[i-1][0];
	        }
	        for(int j=1;j<n;j++){
	            dp[i][j]=dp[i][j-1]+a.get(i).get(j);
	            if(i>0){
	                dp[i][j]=Math.min(dp[i][j],dp[i-1][j]+a.get(i).get(j));
	            }
	        }
	    }
	    return dp[m-1][n-1];
	}

	//Recursive Approach
	public int minPathSumRec(ArrayList<ArrayList<Integer>> a) {
	    m=a.size();
	    n=a.get(0).size();
	    int[][] dp=new int[m][n];
	    for(int i=0;i<m;i++)
	        for(int j=0;j<n;j++)
	            dp[i][j]=Integer.MAX_VALUE;
	    dp[0][0]=a.get(0).get(0);
	    minSum(a,dp,0,0);
	    return dp[m-1][n-1];
	}
	
	private void minSum(ArrayList<ArrayList<Integer>> a,int[][] dp,int i, int j){
	    if(i>=m || j>=n)
	        return;
	    if(i<(m-1) && ((dp[i][j]+a.get(i+1).get(j))<dp[i+1][j])){
	        dp[i+1][j]=dp[i][j]+a.get(i+1).get(j);
	        minSum(a,dp,i+1,j);
	    }
	    if(j<(n-1) && ((dp[i][j]+a.get(i).get(j+1))<dp[i][j+1])){
	        dp[i][j+1]=dp[i][j]+a.get(i).get(j+1);
	        minSum(a,dp,i,j+1);
	    }
	}

}
