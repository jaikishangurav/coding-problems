package dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/*Problem statement:https://www.interviewbit.com/problems/tushars-birthday-party/
 * This problem is variant of unbounded knapsack where instead of maximising we have to minimise the cost.
 * Recurrence Relation:
 * If dp[i,j] represent cost to satisfy person with capacity i with first j dishes.
 * a[j] be the capacity that jth dish satisfies and cost[j] be the cost of jth dish
 * dp[i][j]=min{dp[i][j], dp[i-a[j]][j]+cost[j]]} where i-a[j]>=0
 * dp[i][j]=dp[i][j-1] //otherwise
 * As one dish can be taken multiple times, we have used dp[i-a[j]][j] and not dp[ i-a[j] ][ j-1 ]. 
 * This is different from standard KnapSack where one element can be used only once.
 * */
public class TusharsBirthdayParty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr1=new Integer[]{2, 3, 1, 5, 4};
		List<Integer> a=Arrays.asList(arr1);	//friends capacity array
		arr1=new Integer[]{3, 2, 4, 1};
		List<Integer> b=Arrays.asList(arr1);	//array denoting capacity dish satisfy
		arr1=new Integer[]{1, 2, 5, 10};
		List<Integer> c=Arrays.asList(arr1);	//array denoting cost of the dish
		int minCost=solveDP(a,b,c);
		System.out.println("minimum cost such that all of Tushar’s friends are satisfied:"+minCost);
	}
	
	//Dynamic Programming approach Time Complexity: O(n^2) Space Complexity:O(n)
	public static int solveDP(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int totalCost=0;
        int n=B.size();
        int W=0;
        for(int i=0;i<A.size();i++){
        	W=Math.max(W, A.get(i));	//find maximum capacity among all friends.
        }
        int[] dp=new int[W+1];
        dp[0]=Integer.MAX_VALUE;
        for(int i=0;i<=W;i++){
        	dp[i]=Integer.MAX_VALUE;
            for(int j=0;j<n;j++){
            	if(i==0)
            		dp[i]=0;	//cost for weight 0 is 0.
                else{
                	if(i>=B.get(j)){
                        dp[i]=Math.min(dp[i],dp[i-B.get(j)]+C.get(j));
                    }
                }
            }
        }
        for(int i=0;i<A.size();i++){
        	totalCost+=dp[A.get(i)];
        }

        return totalCost;
    }
	
	//DP Approach Space Complexity:O(n^2)
	//Need to further work on it.
	public static int solveDP2(final List<Integer> A, final List<Integer> B, final List<Integer> C) {
        int totalCost=0;
        int n=B.size();
        for(int t=0;t<A.size();t++){
            int W=A.get(t);
            int[][] dp=new int[W+1][n+1];            
            for(int i=0;i<=W;i++){
                for(int j=0;j<=n;j++){
                    if(i==0)
                        dp[i][j]=0;	//cost for weight 0 is 0.
                    else if(j==0)
                    	dp[i][j]=Integer.MAX_VALUE;
                    else{
                        if(i>=B.get(j-1)){
                            dp[i][j]=Math.min(dp[i][j-1],dp[i-B.get(j-1)][j]+C.get(j-1));
                        }else{
                        	dp[i][j]=dp[i][j-1];
                        }
                    }
                }
            }
            //display(dp);
            //System.out.println();
            totalCost+=dp[W][n];
        }
        return totalCost;
    }
	
	private static void display(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++)
			System.out.print(arr[i][j]+" ");
			System.out.println();
		}

	}

}
