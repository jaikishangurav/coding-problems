package minimal.network;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m;
        n=sc.nextInt();
        m=sc.nextInt();
        System.out.println("n:"+n+" m:"+m);
        int u,v,w;
        int[][] graph= new int[n+1][n+1];
        for(int i=0; i<m; i++){
        	u=sc.nextInt();
        	v=sc.nextInt();
        	w=sc.nextInt();
        	graph[u][v]=w;
        }
        System.out.println(" 1  2  3  4  5  6  7 ");
        
        
    }
}