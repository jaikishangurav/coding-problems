package binarysearch;

import java.util.Scanner;

public class SquareRootOfInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr=new Scanner(System.in);
		int a = sr.nextInt();
		System.out.println(sqrt(a));
	}
	public static int sqrt(int a) {
	    int low=0;
	    int high=a;
	    int ans=0;
	    while(low<=high){
	        int mid=low+(high-low)/2;        
	        if(mid==a/mid && a%mid==0)
	            return mid;
	        else if(mid<=a/mid){
	        	ans=mid;
	           low=mid+1;
	       }else{
	           high=mid-1;
	       }
	    }
	    return ans;
	}
}
