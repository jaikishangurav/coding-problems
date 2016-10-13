package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SortedInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr=new Integer[]{1, 3, 4, 6, 7, 9};
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(arr));
		Scanner sr=new Scanner(System.in);
		int b = sr.nextInt();
		int pos = searchInsert(a, b);
		System.out.println(pos);
	}
	
	public static int searchInsert(ArrayList<Integer> a, int b) {
	    int low=0;
	    int high=a.size()-1;
	    /*if(b<a.get(low))
	        return 0;
	    if(b>a.get(high))
	        return high+1;*/
	    while(low<=high){
	        int mid=low+(high-low)/2;
	        if(a.get(mid)==b){
	            return mid;
	        }else if(a.get(mid)>b){
	            high=mid-1;
	        }else{
	            low=mid+1;
	        }
	    }
	    return low;
	}

}
