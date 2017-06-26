package dynamicProgramming;
/*Problem statement:https://www.interviewbit.com/problems/regular-expression-match/
 * 
 * */
public class RegularExpressionMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String p="*a**************************************************************************************";
		//String s="abc";
		//String p="?*";
		System.out.println(isMatchDP(s, p));
	}
	//DP approach optimized
	public static int isMatchDPOptimized(final String s, final String p) {
	    if(s==null || p==null)
	        return 0;
	    if(p.length()==0 && s.length()==0)
	        return 1;
	    
	    char[] str=s.toCharArray();
	    char[] pattern=p.toCharArray();
	    int index=0;
	    boolean isFirst=true;
	    //club consecutive * as single * in pattern
	    for(int i=0;i<pattern.length;i++){
	    	if(pattern[i]=='*'){
	    		if(isFirst){
	    			pattern[index++]=pattern[i];
	    			isFirst=false;
	    		}
	    	}else{
    			pattern[index++]=pattern[i];
    			isFirst=true;
    		}
	    }
	    boolean[][] dp=new boolean[str.length+1][index+1];
	    dp[0][0]=true;
	    if(pattern[0]=='*')
	    	dp[0][1]=true;
	    for(int i=1;i<=str.length;i++){
	        for(int j=1;j<=index;j++){
	            if(str[i-1]==pattern[j-1] || pattern[j-1]=='?'){
	                dp[i][j]=dp[i-1][j-1];
	            }else if(pattern[j-1]=='*'){
	                dp[i][j]=dp[i-1][j]||dp[i][j-1];
	            }else{
	                dp[i][j]=false;
	            }
	        }
	    }
	    display(dp,str.length,index);
	    
	    
	    return dp[str.length][index]?1:0;
	}
	
	public static int isMatchDP(final String s, final String p) {
	    if(s==null || p==null)
	        return 0;
	    int m=p.length();
	    int n=s.length();
	    if(m==0 && n==0)
	        return 1;
	    boolean[][] dp=new boolean[m+1][n+1];
	    for(int i=0;i<=m;i++){
	        for(int j=0;j<=n;j++){
	            if(i==0 && j==0){
	                dp[i][j]=true;
	            }else if(i==0 && j!=0){
	                dp[i][j]=false;
	            }else if(i!=0 && j==0){
	                if(p.charAt(i-1)=='*'){
	                    dp[i][j]=dp[i-1][j];
	                }else{
	                    dp[i][j]=false;
	                }
	            }else if(s.charAt(j-1)==p.charAt(i-1)){
	                dp[i][j]=dp[i-1][j-1];
	            }else if(p.charAt(i-1)=='?'){
	                dp[i][j]=dp[i-1][j-1];
	            }else if(p.charAt(i-1)=='*'){
	                dp[i][j]=dp[i-1][j]||dp[i][j-1];
	            }else{
	                dp[i][j]=false;
	            }
	        }
	    }
	    display(dp,m,n);
	    return dp[m][n]?1:0;
	}
	
	private static void display(boolean[][] arr,int m, int n){
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++)
			System.out.print(arr[i][j]+" ");
			System.out.println();
		}

	}
}
