package dynamicProgramming;

import java.util.Scanner;

public class IntersectingChordsInCircle {

	private static final long mod=(long) (Math.pow(10,9)+7);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr=new Scanner(System.in);
		int n=sr.nextInt();
		//int ans=factorial(2*n)/(factorial(n+1)*factorial(n));
		//System.out.println(ans);
		System.out.println(chordCnt(n));
		long val=6564120420l;
		System.out.println(mod);
		System.out.println(Integer.MAX_VALUE);
		System.out.println(val%mod);
	}

	public static int chordCnt(int n) {
		if(n == 0) return 1;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
                for(int j = 0; j < i; j++) {
                	dp[i] += (dp[j] * dp[i - 1 - j])%mod;
                }
                System.out.println("dp["+i+"]="+dp[i]);
                if(dp[i]>=mod)
                	dp[i]%=mod;
        }
        return (int) (dp[n]%mod);
    }
	private static int factorial(int number){
		int i,fact=1;   
		  for(i=1;i<=number;i++){    
		      //fact=fact%mod*i;    
		  }    		  
		  System.out.println(fact);
		  return fact;
		  
	}
	

}
