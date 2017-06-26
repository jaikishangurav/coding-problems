package dynamicProgramming;
/*Problem statement:https://www.interviewbit.com/problems/scramble-string/
 * 
 * */
public class ScrambleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="great";
		String b="rgtae";
		System.out.println(isScrambleDP(a, b));
	}
	
	public static int isScrambleRecv(final String a, final String b) {
	    if(a.length()!=b.length())
	        return 0;
	    if(a.equals(b))
	        return 1;
	    int l=a.length();
	    int[] chars=new int[26];
	    String s1=a.toLowerCase();
	    String s2=b.toLowerCase();
	    for(int i=0;i<l;i++){
	        chars[s1.charAt(i)-'a']++;
	        chars[s2.charAt(i)-'a']--;
	    }
	    for(int i=0;i<26;i++){
	        if(chars[i]!=0)
	            return 0;
	    }
	    for(int i=1;i<l;i++){
	        String a1=a.substring(0,i);
	        String a2=a.substring(i,l);
	        String b1=b.substring(0,i);
	        String b2=b.substring(i,l);
	        System.out.println("111111111");
	        System.out.println("Match a1="+a1+" with b1="+b1);
	        System.out.println("Match a2="+a2+" with b2="+b2);
	        if(isScrambleRecv(a1,b1)==1 && isScrambleRecv(a2,b2)==1){
	            return 1;
	        }
	        b1=b.substring(0,l-i);
	        b2=b.substring(l-i,l);
	        System.out.println("22222222");
	        System.out.println("Match a1="+a1+" with b2="+b2);
	        System.out.println("Match a2="+a2+" with b1="+b1);
	        if(isScrambleRecv(a1,b2)==1 && isScrambleRecv(a2,b1)==1){
	            return 1;
	        }
	    }
	    return 0;
	}
	
	public static int isScrambleDP(final String s1, final String s2) {
		if (s1.length() != s2.length())
            return 0;
        if (s1.equals(s2))
            return 1;
            
        int n = s1.length();
        boolean[][][] dp = new boolean[n+1][n+1][n+1];
        for(int l = 1; l <= n; ++l)
        {
            for(int i = 0; i <= n - l; ++i)
            {
                for(int j = 0; j <= n - l; ++j)
                {
                    if( l == 1 )
                        dp[l][i][j] = s1.charAt(i) == s2.charAt(j);
                    for(int k = 1; k < l; ++k)
                    {
                        if( (dp[k][i][j] && dp[l-k][i+k][j+k])
                            || (dp[k][i][j+l-k] && dp[l-k][i+k][j]) )
                        {
                            dp[l][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        display(dp,n);
        return dp[n][0][0]?1:0;
	}
	
	private static void display(boolean[][][] dp, int n){
		for(int i=0;i<=n;i++){
			System.out.println("For i="+i);
			for(int j=0;j<=n;j++){
				for(int k=0;k<=n;k++){
					System.out.print(dp[i][j][k]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}
