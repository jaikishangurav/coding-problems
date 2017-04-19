package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Integer[] a=new Integer[]{7,2,3,6};
		ArrayList<Integer> coins=new ArrayList(Arrays.asList(a));
        int n = 13;
        minNumberOfCoins(coins,n);
        System.out.println("\nNumber of ways to change coin using recursion:"+coinchangeRecursive(coins,coins.size(),n));
        System.out.println("\nNumber of ways to change coin using dp:"+coinchange2(coins,n));
	}
	
	public static int coinchangeRecursive(ArrayList<Integer> a, int b,int n) {
		if(n==0)	//if b==0 then there is 1 solution possible
        	return 1;
        if(n<0)	//if n<0 then there is no solution possible
        	return 0;
        if(b<=0 && n>=1)
        	return 0;
        return coinchangeRecursive(a,b-1,n)+coinchangeRecursive(a,b,n-a.get(b-1));
    }
	
	//return number of ways in which value can be changed using given denominations
	public static int coinchange2(ArrayList<Integer> a, int b) {
        long[] dp=new long[b+1];
        dp[0]=1l;
        for(Integer coin:a){
            for(int j=coin;j<=b;j++){
                dp[j]=(dp[j]+dp[j-coin])%1000007;
            }
        }
        return (int)(dp[b]%1000007);
    }
	
	//Minimum number of coins required to change
	public static void minNumberOfCoins(ArrayList<Integer> coins, int n){
		int[] dp=new int[n+1];
		Arrays.fill(dp, Integer.MAX_VALUE-1);
		dp[0]=0;
		int[] sol=new int[n+1];
		Arrays.fill(sol, -1);
		int m=coins.size();
		for(int i=0;i<m;i++){
			int coin=coins.get(i);
			for(int j=coin;j<dp.length;j++){
				if(dp[j]>(1+dp[j-coin])){
					dp[j]=1+dp[j-coin];
					sol[j]=i;
				}			
			}
		}
		System.out.println("Minimum number of coins:"+dp[n]);
		int index=n;

		System.out.println("Coins used to achieve solution:");
		printCoinCombination(coins,sol);
	}
	
	public static void printCoinCombination(ArrayList<Integer> coins, int[] sol){
		if(sol[sol.length-1]==-1)
			System.out.println("No solution possible");
		int start=sol.length-1;
		while(start!=0){
			int j=sol[start];
			System.out.print(coins.get(j)+" ");
			start-=coins.get(j);
		}		
	}
	
	public static void display(long[] a){
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}

}
