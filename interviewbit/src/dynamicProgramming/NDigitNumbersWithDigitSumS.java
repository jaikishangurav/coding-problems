package dynamicProgramming;
/*Problem statement:https://www.interviewbit.com/problems/n-digit-numbers-with-digit-sum-s/
 * Recurrence Relation:
 * rec_Count(n, s) = ∑ rec_Count(n-1,s-x) where 0 <= x <= 9 && s-x >= 0.
 * 
 * */

public class NDigitNumbersWithDigitSumS {

    private static int[][] dp;
    private static final int MOD=1000000007;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans=solveDP(3,15);
	}
	
	//Recurisve approach Time Complexity: O(2^n)
	public static int solve(int n, int s) {
        int ans=0;
        for(int i=1;i<=9;i++){
            if(s-i>=0)
               ans+= digitSum(n-1,s-i)%(int)(Math.pow(10,9)+7);
        }
        return ans%(int)(Math.pow(10,9)+7);
    }
    
    private static int digitSum(int n,int s){
        if(n==0)
            return s==0?1:0;
        int ans=0;
        for(int i=0;i<=9;i++){
            if(s-i>=0)
               ans+= digitSum(n-1,s-i)%(int)(Math.pow(10,9)+7);
        }
        return ans%(int)(Math.pow(10,9)+7);
    }
    
    //Dynamic programming approach Time Complexity:O(n^2)
    public static int solveDP(int n, int s) {
        dp=new int[n+1][s+1];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=s;j++){
                if(i==1){
                    if(j>0&&j<=9)
                        dp[i][j]=1;
                    else dp[i][j]=0;
                }else{
                    for(int x=0;x<=9;x++){
                        if(j>=x){
                        	//rec_Count(n, s) = ∑ rec_Count(n-1,s-x) where 0 <= x <= 9 && s-x >= 0.
                        	//dp(i,j) = ∑ dp(i-1,j-x) where 1 <= i <= n and 0 <= j <=s and j-x >= 0 and 0 <= x <= 9.
                        	dp[i][j]+=dp[i-1][j-x];
                        }
                        dp[i][j]%=MOD;
                    }
                }
            }
        }
        display(dp);
        return dp[n][s]==0?0:dp[n][s];
    }
    
    private static void display(int[][] arr){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++)
			System.out.print(arr[i][j]+" ");
			System.out.println();
		}

	}

}
