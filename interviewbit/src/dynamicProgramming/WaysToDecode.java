package dynamicProgramming;
/*Problem statement:https://www.interviewbit.com/problems/ways-to-decode/
 * 
 * */
public class WaysToDecode {

	public static void main(String[] args) {
		String s="32925665678138257423442343752148360796465852883409126159293254159974370974059818198867156827877059067081419274873853679038";
		int ways=numDecodings(s);
		System.out.println("Ways to decode:"+ways);
	}
	
	public static int numDecodings(String s) {
		if(s==null || s.length()==0 || s.charAt(0)=='0')
	        return 0;
	    if(s.length()==1)
	        return 1;	 
	    int[] dp = new int[s.length()];    
	    dp[0]=1;
	    if(Integer.parseInt(s.substring(0,2))>26){
	        if(s.charAt(1)!='0'){
	            dp[1]=1;
	        }else{
	            dp[1]=0;
	        }
	    }else{
	        if(s.charAt(1)!='0'){
	            dp[1]=2;
	        }else{
	            dp[1]=1;
	        }
	    }
	 
	    for(int i=2; i<s.length(); i++){
	        if(s.charAt(i)!='0'){
	            dp[i]+=dp[i-1];
	        }
	 
	        int val = Integer.parseInt(s.substring(i-1, i+1));
	        if(val<=26 && val >=10){
	            dp[i]+=dp[i-2];
	        }
	    }
	    System.out.println(s);
	    for(int i=0;i<dp.length;i++)
	    	System.out.print(dp[i]+",");
	    System.out.println();
	    return dp[s.length()-1];
	}

}
