package dynamicProgramming;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sr=new Scanner(System.in);
        int n=sr.nextInt();
        int m=sr.nextInt();
        int[] a=new int[n];
        int[] b=new int[m];
        for(int i=0;i<n;i++)
            a[i]=sr.nextInt();
        for(int i=0;i<m;i++)
            b[i]=sr.nextInt();
        int[][] dp=new int[n+1][m+1];
        char[][] r=new char[n][m];
        for(int i=0;i<=n;i++)
            dp[i][0]=0;
        for(int i=0;i<=m;i++)
            dp[0][i]=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i]==b[j]){
                    dp[i+1][j+1]=dp[i][j]+1;
                    r[i][j]='D';
                }else if(dp[i][j+1]>=dp[i+1][j]){
                    dp[i+1][j+1]=dp[i][j+1];
                    r[i][j]='U';
                }else{
                    dp[i+1][j+1]=dp[i+1][j];
                    r[i][j]='L';
                }
            }
        }
        for(int i=0;i<=n;i++){
        	for(int j=0;j<=m;j++)
        		System.out.print(dp[i][j]+" ");
        	System.out.println();
        }
        for(int i=0;i<n;i++){
        	for(int j=0;j<m;j++)
        		System.out.print(r[i][j]+" ");
        	System.out.println();
        }
        printLCS(r,a,n-1,m-1);        
    }
    
    private static void printLCS(char[][] r,int[] a,int i, int j){
        if(i<0 || j<0)
            return;
        if(r[i][j]=='D'){
            printLCS(r,a,i-1,j-1);
            System.out.print(a[i]+" ");
        }else if(r[i][j]=='U'){
            printLCS(r,a,i-1,j);
        }else{
            printLCS(r,a,i,j-1);
        }
    }
    
}