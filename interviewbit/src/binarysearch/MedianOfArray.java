package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import arrays.FindDuplicateInArray;

public class MedianOfArray {
	public static void main(String[] args){
		Integer[] arr1=new Integer[]{1,5,8,10,12};
		Integer[] arr2=new Integer[]{2,4,7,9};
		List<Integer> a = new ArrayList<>(Arrays.asList(arr1));
		List<Integer> b = new ArrayList<>(Arrays.asList(arr2));
		double ans=findMedianSortedArrays(a,b);
		System.out.println(ans);
	}
	
	public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
		int m=a.size();
		int n=b.size();
		if(m>n)
			return findMedianSortedArrays(b,a);
	    int imin=0;
	    int imax=m;
	    int i,j;
	    while(imin<=imax){
	    	i=(imin+imax)/2;
	    	j=((m+n+1)/2)-i;
	    	if(j>0 && i<m && b.get(j-1)>a.get(i)){
	    		imin=i+1;
	    	}else if(i>0 && j<n && a.get(i-1)>b.get(j)){
	    		imax=i-1;
	    	}else{
	    		int m1=0;
	    		int m2=0;
	    		if(i==0){
	    			m1=b.get(j-1);
	    		}else if(j==0){
	    			m1=a.get(i-1);
	    		}else{
	    			m1=Math.max(a.get(i-1), b.get(j-1));
	    		}
	    		if((m+n)%2==1){
	    			return 1.0*m1;
	    		}
	    		if(i==m){
	    			m2=b.get(j);
	    		}else if(j==n){
	    			m2=a.get(i);
	    		}else{
	    			m2=Math.min(a.get(i), b.get(j));
	    		}
	    		return 1.0*(m1+m2)/2.0;
	    	}
	    }
	    return -1.0;
	    	
	    }
}
	
