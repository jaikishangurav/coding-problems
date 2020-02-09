package dynamicProgramming;
import java.util.ArrayList;
import java.util.Arrays;
/* Problem Statement
 * Count the permutation
You are given two numbers, namely A and S.

Write a program to find the number of ways in which the numbers that are greater than or equal to S can be added to get the sum A. 
Print the result as modulo 10^9+9.

Input format
First line: T (Number of test cases)
First line in each test case: Two space-separated integers A and S

Output format
For each test case, print the number of ways to acquire the sum A using the numbers that are greater than or equal to S.

Constraints:
1 ≤ T ≤ 1000
1 ≤ A , S ≤ 1000

Sample Input				Sample Output
4							2
2 1							3						
3 1							0
4 5							1
750 466

Explanation
In the first test case: <1, 1> and <2> are the 2 ways.

In the second test case: <1,1,1>, <1,2> and <3> are the three ways.

 * */
import java.util.List;
import java.util.Scanner;

public class IntegerPartition {
	
    private static final int MOD=(int)Math.pow(10,9)+9;
    
    public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner sr = new Scanner(System.in);
        int T = sr.nextInt();
        int a,s;
        for (int t = 0; t < T; t++) {
            a=sr.nextInt();
            s=sr.nextInt();
            if(a>1000 || s>1000 || s>a)
                System.out.println(0);
            else{                
                if(s>a/2){
                	System.out.println(1);
                }else{
                	ArrayList<ArrayList<Integer>> result=new ArrayList<>();
                	ArrayList<Integer> temp=new ArrayList<>();
                	countPartitions(result, temp, s, a, a);
                	System.out.println("Solution using Backtracking");
                	System.out.println("Number of ways:"+result.size());
                	for(ArrayList<Integer> ans:result)
                		System.out.println(ans);
                	System.out.println("Solution using DP");
                	int totalWays=countPartitionsDP2(s,a);
                	System.out.println("Number of ways:"+totalWays);
                }
            }    
        }
        sr.close();
        
    }
    
    private static void countPartitions(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int cur, int sum, int A){
    	if(sum==0){
    		ArrayList<Integer> partialAns=new ArrayList<>(temp);
    		result.add(partialAns);
    		return;
    	}
    	
    	for(int i=cur;i<=A;i++){
    		if(sum-i<0)
    			break;
    		temp.add(i);
    		countPartitions(result, temp, i, sum-i, A);
    		temp.remove(temp.size()-1);
    	}
    }
    
    private static int countPartitionsDP(int d, int sum){
    	if(d>sum/2)
    		return 1;
    	if(d>sum)
    		return 0;
    	int coins=sum-d+1;
    	int[][] dp=new int[coins][sum+1];
    	for(int i=0;i<coins;i++){	//for sum=5 and d=2 number that we use to achieve sum is 2,3,4,5 i.e (i+d).
    		for(int j=0;j<=sum;j++){
    			if(j==0)	//sum=0 can be achieved in 1 way. dp[i][0]=1
    				dp[i][j]=1;
    			else if(i==0){
    				if(j<(i+d)){	//if current sum j is less than current value of d i.e.(i+d).
    					dp[i][j]=0;
    				}else{
    					dp[i][j]=dp[i][j-i-d];	//if sum is greater than current value of d then dp[i][j]=dp[i][j-d]
    				}
    			}else if(j<(i+d)){
    				dp[i][j]=dp[i-1][j];
    			}else{
    				dp[i][j]=dp[i-1][j]+dp[i][j-i-d];
    			}
    		}
    	}
    	return dp[coins-1][sum];
    }
    
    private static int countPartitionsDP2(int d, int sum){
    	if(d>sum/2)
    		return 1;
    	if(d>sum)
    		return 0;
    	int coins=sum-d+1;
    	
        long[] dp=new long[sum+1];
        Arrays.fill(dp,0);
        dp[0]=1;
        for(int i=0;i<coins;i++){
            for(int j=i+d;j<=sum;j++){
                dp[j]+=(dp[j-(i+d)]%MOD);
            }
        }
    	return (int)dp[sum];
    }
    
    private static void display(int[] dp){
    	for(int i=0;i<dp.length;i++){
    		System.out.print(dp[i]+" ");
    	System.out.println();
    	}
    }
}
