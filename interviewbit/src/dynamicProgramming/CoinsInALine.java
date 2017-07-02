package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*Problem statement:https://www.interviewbit.com/problems/coins-in-a-line/
 * Recurrence Relation:
 * MV(i, j)  = maximum value the player can collect from i'th coin to j'th coin.
 * MV(i,j)=Max{(a[i] + Min{MV(i+2, j), MV(i+1, j-1)}), (a[j] + Min{MV(i+1, j-1), MV(i, j-2)})}
 * 
 * */
public class CoinsInALine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr=new Integer[]{8, 15, 3, 7};
		ArrayList<Integer> a=new ArrayList<>();
		for(int i=0;i<arr.length;i++)
			a.add(arr[i]);
		int ans=maxcoin(a);
	}
	
	//Dynamic Programmming approach
	public static int maxcoin(ArrayList<Integer> a) {
	    if(a==null || a.size()==0)
	        return 0;
	    int[][] dp=new int[a.size()][a.size()];
	    int d,b,c;
	    for(int gap=0;gap<a.size();gap++){
	        for(int i=0,j=gap;j<a.size();i++,j++){
	            d=(i+2<=j)?dp[i+2][j]:0;
	            b=(i+1<=j-1)?dp[i+1][j-1]:0;
	            c=(i<=j-2)?dp[i][j-2]:0;
	            dp[i][j]=Math.max((a.get(i)+Math.min(d,b)),
	                                a.get(j)+Math.min(b,c));
	        }
	    }
	    return dp[0][a.size()-1];
	}

}
