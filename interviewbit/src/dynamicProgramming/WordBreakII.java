package dynamicProgramming;
/*Problem statement:https://www.interviewbit.com/problems/word-break-ii/
 * Recurrence Relation:
 * DP(i) contain word that end at ith position in string S. 0<=i<=S.length
 * DP(j) = empty list for j=0
 * 		 = null if no word in dictionary end at j
 * 		 = substring(i,j) starting at ith position and end at jth position. 0<=i,j<=S.length
 * 
 * */
import java.util.*;

public class WordBreakII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "catsanddog";
		String[] words=new String[]{"cat", "cats", "and", "sand", "dog"};
		ArrayList<String> wordList=new ArrayList<>();
		for(String str:words)
			wordList.add(str);
		ArrayList<String>sentences=wordBreak(s, wordList);
		System.out.println(sentences);
	}
	
	public static ArrayList<String> wordBreak(String a, ArrayList<String> b) {
        ArrayList<String> [] dp=new ArrayList[a.length()+1];
        dp[0]=new ArrayList<String>();
        for(int start=0;start<a.length();start++){
            if(dp[start]!=null){
                for(int end=start+1;end<=a.length();end++){
                    String sub=a.substring(start,end);
                    if(b.contains(sub)){
                        if(dp[end]==null){
                            ArrayList<String> temp=new ArrayList<>();
                            temp.add(sub);
                            dp[end]=temp;
                        }else{
                            dp[end].add(sub);
                        }
                    }
                }
            }
        }
        for(int i=0;i<dp.length;i++){
        	System.out.println(i+":"+dp[i]);
        }
        if(dp[a.length()]==null){
            return new ArrayList<String>();
        }else{
            ArrayList<String> result=new ArrayList<>();
            dfs(dp,result,"",a.length());
            Collections.sort(result);
            return result;
        }
	}
	private static void dfs(ArrayList<String> [] dp,ArrayList<String> result,String curr, int i){
	    if(i==0){
	        result.add(curr.trim());
	        return;
	    }
	    for(String s:dp[i]){
	        String combined=s+" "+curr;
	        dfs(dp,result,combined,i-s.length());
	    }
	}

}
