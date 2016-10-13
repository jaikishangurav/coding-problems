package algos.rodCutting;

import java.util.Scanner;

public class RodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p={1,5,8,9,10,17,20,24,30};
		Scanner sr = new Scanner(System.in);
		System.out.print("length li |");
		for(int i=0;i<p.length;i++)
			System.out.print(i+1+"  ");
		System.out.println();
		System.out.println("-----------------------------------------");
		System.out.print("price pi  |");
		for(int i=0;i<p.length;i++)
			System.out.print(p[i]+" ");
		System.out.println();
		int n=sr.nextInt();
		int rn=memoizedCutRod(p,n);
		System.out.println("Max revenue for length "+n+" is :"+rn);
	}

	public static int cutRod(int[] p, int n){
		if(n==0)
			return 0;
		int q=Integer.MIN_VALUE;
		for(int i=0;i<n;i++){
			q=Math.max(q,p[i]+cutRod(p,n-i-1));			
			System.out.println("i :"+i+" q :"+q);
		}
		return q;	
	}
	
	public static int memoizedCutRod(int[] p,int n){
		int[] r = new int[n+1];
		for(int i=0;i<=n;i++)
			r[i]=Integer.MIN_VALUE;
		return memoizedCutRodAux(p,n,r);	
	}
	
	public static int memoizedCutRodAux(int[] p, int n,int[] r){
		if(r[n]>=0)
			return r[n];
		int q;
		if(n==0)
			q=0;
		else {
			q=Integer.MIN_VALUE;
			for(int i=0;i<n;i++){
				q=Math.max(q,p[i]+memoizedCutRodAux(p,n-i-1,r));
			}
		}
		r[n]=q;
		return q;
	}
	
}

