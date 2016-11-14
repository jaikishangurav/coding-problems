package dynamicProgramming;

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcbm";
		int cuts=minCut(s);
		System.out.println(cuts);
	}
	public static int minCut(String a) {
	    int n=a.length();
	    int[][] dp=new int[n][n];
	    int ans=0;
	    for(int i=0;i<n;i++)
	        dp[i][i]=0;
	    for(int l=2;l<=n;l++){
	        for(int i=0;i<n-l+1;i++){
	            int j=i+l-1;
	            if(isPalindrome(a,i,j)){
	                dp[i][j]=0;
	            }else{
	                dp[i][j]=Integer.MAX_VALUE;
	                for(int k=i;k<j;k++){
	                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+1);
	                }
	            }
	        }
	    }
	    display(dp,n);
	    return dp[0][n-1];
	}
	private static boolean isPalindrome(String a, int i, int j){
	    String s=a.substring(i,j+1);
	    StringBuffer sb=new StringBuffer(s);
	    String rev=sb.reverse().toString();
	    //System.out.println(s+" : "+rev);
	    return s.equals(rev);
	}
	private static void display(int[][] a, int n){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}

}
