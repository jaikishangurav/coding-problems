package dynamicProgramming;

import java.util.Scanner;

public class Candies {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sr=new Scanner(System.in);
        int n=sr.nextInt();
        int[] ratings=new int[n];
        for(int i=0;i<n;i++)
            ratings[i]=sr.nextInt();
        int[] cand=new int[n];
	    for(int i=0;i<n;i++){
	        cand[i]=1;
	    }
	    for(int i=1;i<n;i++){
	        if(ratings[i]>ratings[i-1]){
	            cand[i]=cand[i-1]+1;
	        }
	    }
	    for(int i=n-2;i>=0;i--){
	        if(ratings[i]>ratings[i+1]){
	            cand[i]=Math.max(cand[i],cand[i+1]+1);
	        }
	    }
	    long total=0;
	    for(int i=0;i<n;i++){
	        total+=cand[i];
	    }
	    System.out.println(total);
    }
}
