package dynamicProgramming;
/*Problem statement:https://www.interviewbit.com/problems/interleaving-strings/
 * 
 * */
public class InterleavingStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="dbbca";
		String b="aabcc";
		String c="aadbbcbcac";
		int ans=isInterleave(a, b, c);
		if(ans==1){
			System.out.println("String "+c+" can be formed by interleaving "+a+" and "+b);
		}else System.out.println("String "+c+" cannot be formed by interleaving "+a+" and "+b);
		System.out.println("Answer:"+ans);
	}
	
	public static int isInterleave(String a, String b, String c) {
	    int m=a.length();
	    int n=b.length();
	    int l=c.length();
	    if(m+n!=l)
	        return 0;
	    boolean[][] dp=new boolean[m+1][n+1];
	    for(int i=0;i<=m;++i){
	        for(int j=0;j<=n;++j){
	        	//both string a and b are empty
	            if(i==0 && j==0){
	                dp[i][j]=true;
	            }
	            //string a is empty
	            else if(i==0 && b.charAt(j-1)==c.charAt(j-1)){
	                dp[i][j]=dp[i][j-1];
	            }
	            //String b is empty
	            else if(j==0 && a.charAt(i-1)==c.charAt(i-1)){
	                dp[i][j]=dp[i-1][j];
	            }
	            //(i+j-1)th character of string c matches with (i-1)th character of a and doesnt match with (j-1)th character of string b
	            else if(i!=0 && j!=0 && a.charAt(i-1)==c.charAt(i+j-1) && b.charAt(j-1)!=c.charAt(i+j-1)){
	                dp[i][j]=dp[i-1][j];
	            }
	            //(i+j-1)th character of string c matches with (j-1)th character of b and doesnt match with (i-1)th character of string a
	            else if(i!=0 && j!=0 && a.charAt(i-1)!=c.charAt(i+j-1) && b.charAt(j-1)==c.charAt(i+j-1)){
	                dp[i][j]=dp[i][j-1];
	            }
	          //(i+j-1)th character of string c matches with (j-1)th character of b and also matches with (i-1)th character of string a
	            else if(i!=0 && j!=0 && a.charAt(i-1)==c.charAt(i+j-1) && b.charAt(j-1)==c.charAt(i+j-1)){
	                dp[i][j]=(dp[i-1][j]||dp[i][j-1]);
	            }else{
	                dp[i][j]=false;
	            }
	        }
	    }
	    display(dp);
	    return dp[m][n]==true?1:0;
	    
	}
	
	public static void display(boolean[][] dp){
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[0].length;j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
	}

}
