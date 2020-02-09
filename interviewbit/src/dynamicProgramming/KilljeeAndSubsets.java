package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class KilljeeAndSubsets {
	private static final int MOD=(int)Math.pow(10,9)+7;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         int n = Integer.parseInt(br.readLine().trim());
         String[] arr_a = br.readLine().split(" ");
         int[] a = new int[n];
         for(int i_a=0; i_a<arr_a.length; i_a++)
         {
         	a[i_a] = Integer.parseInt(arr_a[i_a]);
         }
 
         int out_ = solve(a);
         System.out.println("Brute Force:"+out_);
         out_ = solveDP(a);
         System.out.println("Dynamic Programing:"+out_);
         out_ = solveDP2(a);
         System.out.println("Dynamic Programing 2:"+out_);
         wr.close();
         br.close();
    }
    
    //brute-force approach Exponential time complexity
    static int solve(int[] a){
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            largest=Math.max(largest,a[i]);
        }
        int[] codes=new int[largest+1];
        Arrays.fill(codes, 0);
        getCode(a,codes,largest);
        long[] t=new long[largest+1];
        t[0]=1;
        for(int i=1;i<t.length;i++){
        	t[i]=((t[i-1]*31)%MOD);
        }
        long code=0;
        for(int j=0;j<=largest;j++){           
                int size=codes[j];
                code+=(size*t[j])%MOD;
                //code%=MOD;
        }
        while(code>MOD)
            code=code%MOD;
        return (int)code;
    }
    
    static void getCode(int[] a,int[] codes,int largest){
        int n=a.length;
        for(int counter=1;counter<(1<<n);counter++){
            int set_xor=0;
            int set_size=0;
            for(int j=0;j<a.length;j++){
                 if ((counter & (1 << j)) > 0){
                     set_xor^=a[j];
                     set_size++;
                 }
            }
            if(set_xor<=largest){
                codes[set_xor]=Math.max(codes[set_xor], set_size);
            }
        }
    }
    
    static int solveDP(int[] a){
    	int largest=Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            largest=Math.max(largest,a[i]);
        }
        int[][] dp=new int[a.length+1][largest+1];
        for(int i=0;i<=a.length;i++){
            for(int j=0;j<=largest;j++){
                dp[i][j] = -1;
            }
        }
        dp[0][0]=0;
        int[] ans=new int[largest+1];
        Arrays.fill(ans, 0);
        for(int i=1;i<=a.length;i++){
        	for(int j=0;j<=largest;j++){
        		if(dp[i-1][j]!=-1 && (j^a[i-1])<=largest){
        			dp[i][j^a[i-1]]=Math.max(dp[i][j^a[i-1]], dp[i-1][j]+1);
        		}
        		dp[i][j]=Math.max(dp[i][j], dp[i-1][j]);
        		if(dp[i][j]!=-1){
        			ans[j]=Math.max(ans[j], dp[i][j]);
        		}
        	}
        }
        //System.out.println("DP table:");
        //display(dp);
        long arrayCode=0;
        long[] t=new long[largest+1];
        t[0]=1;
        for(int i=1;i<t.length;i++){
        	t[i]=((t[i-1]*31)%MOD);
        }
        //System.out.println("Ans array:");
        for(int j=0;j<ans.length;j++){
        	System.out.print(ans[j]+" ");
        	arrayCode=arrayCode%MOD+(((long)dp[a.length][j])*t[j])%MOD;
        }
        System.out.println();
        return (int)arrayCode%MOD;
    }
    
    static int solveDP2(int[] a){
        long ans = 0;
        int n = a.length;
        int mx = -1000;
        for(int i=0;i<n;i++)
        {
            if(a[i]>mx)
                mx = a[i];
        }
        int dp[][]=new int[n+1][1024];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=1023;j++)
                dp[i][j] = -100000;
        dp[0][0] = 0;
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<1024;j++)
            {
                dp[i][j] = Math.max(dp[i-1][j],1+dp[i-1][j^a[i-1]]);
            }
        }
        display(dp);
        long t[] = new long[mx+1];
        t[0]=1;
        for(int i=1;i<=mx;i++)
        {
            t[i] = (t[i-1]*31)%1000000007;
        }
        for(int i=0;i<=mx;i++)
        {
        	System.out.print(dp[n][i]+" ");
            ans = (ans%1000000007 + (t[i]*((long)dp[n][i]))%1000000007)%1000000007;
        }
        System.out.println();
        return (int)ans;
    }
    
    static void display(int[][] dp){
    	for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }
}
/*Sample input
4
1 2 3 4

Output

*/
