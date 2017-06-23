package dynamicProgramming;
/*Problem statement:https://www.interviewbit.com/problems/distinct-subsequences/
 * 
 * */
public class DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="RABBBIT";
		String t="RABBIT";
		DistinctSubsequences obj=new DistinctSubsequences();
		System.out.println("Number of distinct subsequences:"+obj.numDistinctRec(s, t));
	}
	
	//Distinct subsequences dynamic programming approach
	public int numDistinctDP(String s, String t) {
	    int m=t.length();
	    int n=s.length();
	    if(m>n)
	        return 0;
	    int[][] dp=new int[m+1][n+1];
	    for(int i=1;i<=m;i++){
	        dp[i][0]=0;
	    }
	     for(int j=0;j<=n;j++){
	        dp[0][j]=1;    
	     }
	     for(int i=1;i<=m;i++){
	         for(int j=1;j<=n;j++){
	             if(t.charAt(i-1)==s.charAt(j-1)){
	                 dp[i][j]=dp[i-1][j-1]+dp[i][j-1];
	             }else{
	                 dp[i][j]=dp[i][j-1];
	             }
	         }
	     }
	     return dp[m][n];
	}
	
	//Distinct subsequences recursive approach
	public int numDistinctRec(String s, String t){
		int m=t.length();
		int n=s.length();
		if(m>n)
			return 0;
		return distinctSubsequencesRec(s, t, m-1, n-1);
	}
	
	private int distinctSubsequencesRec(String s, String t,int m, int n){
		if(m==0)
			return 1;
		if(n==0)
			return 0;
		if(s.charAt(n)!=t.charAt(m))
			return distinctSubsequencesRec(s, t, m, n-1);
		else{
			return distinctSubsequencesRec(s, t, m-1, n-1)+distinctSubsequencesRec(s, t, m, n-1);
		}
	}

}
