package dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Problem statement:https://www.interviewbit.com/problems/longest-arithmetic-progression/
 * 
 * */
public class LongestArithmeticProgression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr=new Integer[]{3,6,9,12,15};
		List<Integer> a=Arrays.asList(arr);
		int ans=solveDPInN2(a);
		System.out.println("Longest arithmetic progression : "+ans);
	}
	
	//brute force O(n^3)
	 public static int solve(final List<Integer> a) {
	        int n=a.size();
	        if(n<2)
	            return n;
	        int ans=0;
	        for(int i=0;i<n-1;i++){
	            for(int j=i+1;j<n;j++){
	                int lst=a.get(j);
	                int diff=a.get(j)-a.get(i);
	                int cur=2;
	                for(int k=j+1;k<n;k++){
	                    if(a.get(k)==(lst+diff)){
	                        cur++;
	                        lst=a.get(k);
	                    }
	                }
	                ans=Math.max(ans,cur);
	            }
	            
	        }
	        return ans;
	    }
	 
	 public static int solveDPInN3(final List<Integer> a) {
	        int n=a.size();
	        if(n<3)
	            return n;
	        int ans=0;
	        int[][] dp=new int[n][n];
	        for(int i=0;i<n;i++){
	            for(int j=i+1;j<n;j++){
	            	dp[i][j]=2;
	                int need=2*a.get(i)-a.get(j);
	                int pos=-1;
	                for(int k=0;k<i;k++){
	                	if(a.get(k)==need){
	                		pos=k;
	                	}
	                }
	                if(pos!=-1){
	                	dp[i][j]=Math.max(dp[i][j], dp[pos][i] + 1);
	                }
	                ans=Math.max(ans, dp[i][j]);
	            }
	            
	        }
	        display(dp);
	        return ans;
	    }
	 
	 public static int solveDPInN2(final List<Integer> a) {
	        int n=a.size();
	        if(n<3)
	            return n;
	        int ans=0;
	        int[][] dp=new int[n][n];
	        Map<Integer,Integer> map=new HashMap<>();
	        for(int i=0;i<n;i++){
	            for(int j=i+1;j<n;j++){
	            	dp[i][j]=2;
	                int need=2*a.get(i)-a.get(j);
	                if(map.containsKey(need)){
	                	int pos=map.get(need);
	                	dp[i][j]=Math.max(dp[i][j], dp[pos][i] + 1);
	                }
	                ans=Math.max(ans, dp[i][j]);
	            }
	            map.put(a.get(i), i);
	            
	        }
	        display(dp);
	        
	        return ans;
	    }
	 
	 public static void display(int[][] dp){
			for(int i=0;i<dp.length;i++){
				for(int j=0;j<dp[0].length;j++){
					System.out.print(dp[i][j]+" ");
				}
				System.out.println();
			}
		}

}
