package backtracking;

import java.util.ArrayList;

public class PalindromePartitioning {
	static ArrayList<ArrayList<String>> result=new ArrayList<>();
	static ArrayList<String> temp=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a="aabb";
		System.out.println(partition(a));
	}
	public static ArrayList<ArrayList<String>> partition(String a) {
	    if(a==null)
	        return null;
	    if(a.length()==1){
	        temp.add(a);
	        result.add(temp);
	        return result;
	    }
	    dfs(0,a.length(),a);
	   return result;     
	}
	
	private static void dfs(int start, int end, String a){
	    if(start==end){
	        ArrayList<String> tempAns=new ArrayList<>(temp);
	        result.add(tempAns);
	        return;
	    }
	    for(int i=start+1;i<=end;i++){
	        String sub=a.substring(start,i);
	        System.out.println("Substring:"+sub);
	        if(isPalindrome(sub)){
	            temp.add(sub);
	            System.out.println("Start:"+start+" || Before:"+temp);
	            dfs(i,end,a);
	            temp.remove(temp.size()-1);
	            System.out.println("Start:"+start+" || After:"+temp);
	        }
	    }
	}
	
	private static boolean isPalindrome(String s){
	    StringBuilder sb=new StringBuilder(s);
	    StringBuilder rev=new StringBuilder(s);
	    rev=rev.reverse();
	    return sb.toString().equals(rev.toString());
	}
}
