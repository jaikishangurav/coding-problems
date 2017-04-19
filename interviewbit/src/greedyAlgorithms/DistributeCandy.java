package greedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class DistributeCandy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer[] ratings=new Integer[]{9,8,7,6,5,4,3,2,1};
		Integer[] ratings=new Integer[100000];
		for(int i=0;i<ratings.length;i++)
			ratings[i]=i+1;
		System.out.println("Ratings");
		for(int i=0;i<ratings.length;i++){
			System.out.print(ratings[i]+" ");
		}
		System.out.println();
		ArrayList<Integer> a=new ArrayList<>(Arrays.asList(ratings));
		int totalCandies=candy(a);
		System.out.println("Total Candies required:"+totalCandies);
	}
	public static int candy(ArrayList<Integer> a) {
	    int n=a.size();
	    int[] cand=new int[n];
	    for(int i=0;i<n;i++){
	        cand[i]=1;
	    }
	    display(cand,"Initial");
	    for(int i=1;i<n;i++){
	        if(a.get(i)>a.get(i-1)){
	            cand[i]=cand[i-1]+1;
	        }
	    }
	    display(cand,"Left Pass");
	    for(int i=n-2;i>=0;i--){
	        if(a.get(i)>a.get(i+1)){
	        	//System.out.print("for "+i+":"+cand[i]+"||"+cand[i+1]+1);
	            cand[i]=Math.max(cand[i],cand[i+1]+1);
	            //System.out.println();
	        }
	    }
	    display(cand,"Right Pass");
	    System.out.println();
	    int total=0;
	    for(int i=0;i<n;i++){
	        total+=cand[i];
	    }
	    System.out.println(cand[cand.length-1]);
	    return total;
	}
	public static void display(int[] a,String des){
		System.out.println(des+":");
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}


}
