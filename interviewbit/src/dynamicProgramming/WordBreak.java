package dynamicProgramming;
/*Problem statement:https://www.interviewbit.com/problems/word-break/
 * Recurrence Relation:
 * DP(i) be true if substring ending at ith position in present in dictionary. 0<=i<=S.length
 * DP(j) = true for j=0
 * 		 = false if word ending at j is not present in dictionary
 * 		 = true if substring starting at ith position and end at jth position is present in dictionary. 0<=i,j<=S.length
 * 
 * */
import java.util.ArrayList;

public class WordBreak {

	public static void main(String[] args) {
		String s = "catsanddog";
		String[] words=new String[]{"cat", "cats", "and", "sand", "dog"};
		ArrayList<String> wordList=new ArrayList<>();
		for(String str:words)
			wordList.add(str);
		int ans=wordBreak(s, wordList);
		if(ans==1)
			System.out.println("String can be segmented into a space-separated sequence of one or more dictionary words");
		else System.out.println("String cannot be segmented into a space-separated sequence of one or more dictionary words");
	}
	
	public static int wordBreak(String a, ArrayList<String> b) {
	    if(a==null || a.length()==0)
	        return 1;
	    boolean[] dp=new boolean[a.length()+1];
	    dp[0]=true;
	    for(int start=0;start<a.length();start++){
	        if(dp[start]){
	            for(String s:b){
	                int len=s.length();
	                int end=start+len;
	                if(end>a.length())
	                    continue;
	                if(dp[end])
	                    continue;
	                if(a.substring(start,end).equals(s))
	                    dp[end]=true;
	            }
	        }
	    }
	    return dp[a.length()]?1:0;
	}

}
