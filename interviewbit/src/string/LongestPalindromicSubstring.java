package string;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ans =longestPalindrome("abacdfgdcaba");
		System.out.println(ans);
	}

	public static String longestPalindrome(String a) {
	    String rev=new String();
	    StringBuffer sb=new StringBuffer(a);
	    rev=sb.reverse().toString();
	    //System.out.println(rev);
	    int len=a.length();
	    int[][] lp=new int[len+1][len+1];
	    for(int i=0;i<=len;i++){
	    	lp[i][0]=0;
	    	lp[0][i]=0;
	    }
	    for(int i=1;i<=len;i++){
	    	for(int j=1;j<=len;j++){
	    		if(rev.charAt(j-1)==a.charAt(i-1)){
	    			lp[i][j]=lp[i-1][j-1]+1;
	    		}else{
	    			lp[i][j]=Math.max(lp[i-1][j], lp[i][j-1]);
	    		}
	    	}
	    }
	    /*for(int i=0;i<=len;i++){
		    for(int j=0;j<=len;j++)
		    	System.out.print(lp[i][j]+" ");
		    System.out.println();
	    }  */   
	    return getPalindrome(lp,a,rev);
	}
	
	public static String getPalindrome(int[][] lp,String a, String b){
		StringBuffer ans =new StringBuffer();
		int j=a.length();
		int i=a.length();
		while(j>0 && i>0){
			if(a.charAt(i-1)==b.charAt(j-1)){
				ans.append(a.charAt(i-1));
				i-=1;
				j-=1;
			}else{
				if(lp[i-1][j]>lp[i][j-1]){
					i-=1;
				}else if(lp[i-1][j]<lp[i][j-1]){
					j-=1;
				}else{
					j-=1;
				}
			}
		}
		return ans.toString();
	}
}
