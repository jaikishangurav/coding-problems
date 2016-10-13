package algos.rodCutting;

import java.util.Scanner;

public class BottomUpCutRod {

	public static void main(String[] args) {
		int[] p={1,5,8,9,10,17,17,20,24,30};
		//Scanner sr = new Scanner(System.in);
		System.out.print("length li |");
		for(int i=0;i<p.length;i++)
			System.out.print(i+1+"  ");
		System.out.println();
		System.out.println("-----------------------------------------");
		System.out.print("price pi  |");
		for(int i=0;i<p.length;i++)
			System.out.print(p[i]+"  ");
		//System.out.println("Enter rod length:");
		//int n=sr.nextInt();
		System.out.println();
		for(int i=1;i<=10;i++){
			int rn=bottomUpCutRod(p,i);
			System.out.println("Max revenue for length "+i+" is :"+rn);
		}
	}
	
	
	private static int bottomUpCutRod(int[] p, int n){
		int[] r = new int[n+1];				//array to store revenue for rod length
		int[] s = new int[n+1];							//array to store solution
		r[0]=0;
		int q;
		//for(int i=0;i<n;i++)
		//	System.out.print(r[i]+" ");
		for(int j=1;j<=n;j++){
			q=Integer.MIN_VALUE;
			//System.out.println("***For j="+j+"***");
			for(int i=1;i<=j;i++){
				//System.out.println("For i="+i);
				//displayR(r);
				//System.out.println("max("+q+","+(p[i-1]+r[j-i])+")");
				q=Math.max(q,p[i-1]+r[j-i]);
			}
			//System.out.println("r["+j+"]="+q);
			r[j]=q;
		}
		return r[n];
	}
	
	private static int extendedBottomUpCutRod(int[] p, int n){
		int[] r = new int[n+1];				//array to store revenue for rod length
		int[] s = new int[n+1];				//array to store solution
		r[0]=0;
		int q;
		//for(int i=0;i<n;i++)
		//	System.out.print(r[i]+" ");
		for(int j=1;j<=n;j++){
			q=Integer.MIN_VALUE;
			//System.out.println("***For j="+j+"***");
			for(int i=1;i<=j;i++){
				if(q<p[i]+r[j-i]){
				//System.out.println("For i="+i);
				//displayR(r);
				//System.out.println("max("+q+","+(p[i-1]+r[j-i])+")");
				q=Math.max(q,p[i-1]+r[j-i]);
				s[j]=i;
				}
			}
			//System.out.println("r["+j+"]="+q);
			r[j]=q;
		}
		return r[n];
	}
	
	public static void printCutRodSolution(int )
	
	public static void displayR(int[] r){
		System.out.print("r[]={");
		for(int i=0;i<r.length;i++)
			System.out.print(r[i]+", ");
		System.out.print("}");
		System.out.println();
	}

}
