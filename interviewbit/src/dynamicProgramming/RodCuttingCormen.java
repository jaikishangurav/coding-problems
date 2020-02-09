package dynamicProgramming;

import java.util.Arrays;

/*Problem statement:Given a rod of length n inches and a table of prices pi for i=1,2,3,...n, determine the maximum revenue rn obtainable by cutting up the rod
 * and selling the pieces. Note that if price pn for rod of length n is large enough, an optimal solution may require no cutting at all.
 * Recurrence Relation:
 * R(n)  = maximum revenue obtainable by cutting the rod.
 * If an optimal solution cuts the rod into k pieces 1<=k<=n then
 * n=i1+i2+...+ik
 * R(n)=p(i1)+p(i2)+..+p(ik)	where p(ik) is price of piece of length ik.
 * R(n)=MAX{pn, R(1)+R(n-1), R(2)+R(n-2),....., R(n-1)+R(1)}
 * R(n)=MAX{pi+R(n-i)} where 1<=i<=n
 * 
 * This is our solution. We can implement this DP recursively with memoisation. Total complexity will be O(N^3).
 * For actually building the solution, after calculating dp(i, j), we can store the index k which gave the minimum cost and then we can build the solution backwards.
 * 
 * */
public class RodCuttingCormen {

	public static void main(String[] args) {
		int[] price={1,5,8,9,10,17,17,20,24,30};
		int[] length={1,2,3,4,5,6,7,8,9,10};
		int n=7;
		int revenue=0;
		revenue=cutRod(price, length, n);
		System.out.println("Maximum revenue obtainable for rod of length "+n+" is "+revenue);
		revenue=cutRodDP1(price, length, n);
		System.out.println("Maximum revenue obtainable using memoization for rod of length "+n+" is "+revenue);
		revenue=cutRodDP2(price, length, n);
		System.out.println("Maximum revenue obtainable using bottom up DP for rod of length "+n+" is "+revenue);
	}
	
	//brute force
	public static int cutRod(int[] price, int[] length,int n){
		if(n==0)
			return 0;
		int revenue=Integer.MIN_VALUE;
		for(int i=1;i<=n;i++){
			revenue=Math.max(revenue, price[i-1]+cutRod(price,length,n-i));
		}
		return revenue;
	}
	
	
	//recursion with memoization top down DP
	public static int cutRodDP1(int[] price, int[] length,int n){
		int[] dp=new int[n+1];
		Arrays.fill(dp, Integer.MIN_VALUE);
		
		return memoizedCutRod(price, length, n, dp);
	}
	
	private static int memoizedCutRod(int[] price, int[] length, int n, int[] dp){
		if(dp[n]>=0)
			return dp[n];
		int revenue=Integer.MIN_VALUE;
		if(n==0)
			revenue=0;
		else{
			for(int i=1;i<=n;i++){
				revenue=Math.max(revenue, price[i-1]+memoizedCutRod(price,length,n-i,dp));
			}
		}
		dp[n]=revenue;
		return revenue;	
			
	}
	
	//Bottom up DP
		public static int cutRodDP2(int[] price, int[] length,int n){
			int[] dp=new int[n+1];
			dp[0]=0;
			for(int j=1;j<=n;j++){
				int revenue=Integer.MIN_VALUE;
				for(int i=1;i<=j;i++){
					revenue=Math.max(revenue, price[i-1]+dp[j-i]);
				}
				dp[j]=revenue;
			}
			return dp[n];			
		}
	

}
