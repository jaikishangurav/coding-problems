package dynamicProgramming;
/*Problem statement:https://www.interviewbit.com/problems/distinct-subsequences/
 * Recurrence Relation:
 * minJumps(i,j) represent min jumps required to reach from ith position to jth position in array
 * minJumps(start,end)=min(minJumps(k,end)) for all k reachable from start
 * 
 * */
import java.util.ArrayList;

public class MinJumpsArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,3,1,1,2,4,2,0,1,1};
		ArrayList<Integer> a=new ArrayList<>();
		for(int i=0;i<arr.length;i++)
			a.add(arr[i]);
		int ansRec=jumpRec(a);
		System.out.println("Answer using recursive approach:"+ansRec);
		int ansDP=jumpDP(a);
		System.out.println("Answer using DP approach:"+ansDP);
	}
	
	//Recursive approach Time Complexity:Exponential
	public static int jumpRec(ArrayList<Integer> a) {
	    return minJumps(a,0,a.size()-1);
	}
	
	private static int minJumps(ArrayList<Integer> a, int start, int end){
		if(start==end)
			return 0;
		if (a.get(start) == 0)
		     return Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;
		for(int i=start+1;i<=(start+a.get(start)) && i<=end;i++){
			int jumps=minJumps(a,i,end);
			if(jumps != Integer.MAX_VALUE && jumps + 1 < min)
		           min = jumps + 1;
		}
		return min;

	}
	
	//Dynamic programming approach Time Complexity:O(n^2)
	public static int jumpDP(ArrayList<Integer> a) {
	    int n=a.size();
	    if(n==1)
	        return 0;
	    int[] dp=new int[n];
	    for(int i=1;i<n;i++)
	        dp[i]=Integer.MAX_VALUE;
	    dp[0]=0;
	    int[] jumpPath=new int[n];
	    jumpPath[0]=-1;
	    for(int i=1;i<a.size();i++){
	    	for(int j=0;j<i;j++){
	    		if(a.get(j)+j>=i){
	    			if(dp[i]>dp[j]+1){
	    				dp[i]=dp[j]+1;
	    				jumpPath[i]=j;
	    			}	    				
	    		}
	    	}
	    }
	    System.out.println("Path for jumps:");
	    for(int i=0;i<jumpPath.length;i++)
	    	System.out.print(jumpPath[i]+" ");
	    System.out.println();	    
	    return dp[n-1];
	}
	
	//Grredy approach Time Complexity:O(n)
	public static int jumpGreedy(ArrayList<Integer> a) {
	    if(a.size()<=1)
	        return 0;
	    if(a.get(0)>=a.size()-1)
	        return 1;
	    int ladder=a.get(0);
	    int stairs=a.get(0);
	    int ans=-1;
	    int jump=1;
	    for(int level=1;level<a.size();level++){
	        if(level==a.size()-1)
	            return ans;
	        if(level+a.get(level)>ladder)
	            ladder=level+a.get(level);
	        stairs--;
	        if(stairs==0){
	            jump++;
	            ans=jump;
	            stairs=ladder-level;
	        }
	    }
	    return ans;
	}
}
