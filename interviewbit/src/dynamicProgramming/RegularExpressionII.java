package dynamicProgramming;
/*Problem statement:https://www.interviewbit.com/problems/regular-expression-ii/
 * 
 * */
public class RegularExpressionII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcbcd";
		String p="a.*c.*d";
		//String s="abc";
		//String p="?*";
		System.out.println(isMatch(s, p));
	}
	
	public static int isMatch(final String s, final String p) {
	    if(s==null || p==null)
	        return 0;
	    if(s.length()==0 && p.length()==0)
	        return 1;
	    if(p.length()==0 && s.length()!=0)
	        return 0;
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
	    for(int j=2;j<dp[0].length;j++){
	    	if(pattern[j-1]=='*')
	    		dp[0][j]=dp[0][j-2];
	    }
	    for(int i=1;i<=str.length;i++){
	        for(int j=1;j<=index;j++){
	        	//if current character in string character in pattern or current character in pattern is '.'
	            if(str[i-1]==pattern[j-1] || pattern[j-1]=='.'){
	                dp[i][j]=dp[i-1][j-1];
	            }else if(pattern[j-1]=='*'){
	            	dp[i][j]=dp[i][j-2];	//if zero occurrence present in string of character preceding '*' in pattern
	            	//if current character matches in character preceding '*' in pattern OR character preceding '*' is '
	                if(str[i-1]==pattern[j-2] || pattern[j-2]=='.'){	
	                    dp[i][j]=dp[i][j] || dp[i-1][j];	//(i-1) character is repeated at ith position OR '.' is repeated. '.*' means '...' and can match 'aaa' or 'abc'         
	                }	               
	            }else{
	                dp[i][j]=false;
	            }
	        }
	    }
	    display(dp,str.length,index);
	    return dp[str.length][index]?1:0;
	}
	
	private static void display(boolean[][] arr,int m, int n){
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++)
			System.out.print(arr[i][j]+" ");
			System.out.println();
		}

	}

}
