package twopointers;

import java.util.List;

public class Array3Pointers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
	    int m=a.size();
	    int n=b.size();
	    int p=c.size();
	    int i=0,j=0,k=0;
	    int res_i =0, res_j = 0, res_k = 0;
	    int diff=Integer.MAX_VALUE;
	    while(i<m && j<n && k<p){
	        int minimum=Math.min(a.get(i),Math.min(b.get(j),c.get(k)));
	        int maximum=Math.max(a.get(i),Math.max(b.get(j),c.get(k)));
	        if(maximum-minimum<diff){
	            res_i = i; res_j = j; res_k = k;
                diff = maximum - minimum;
	        }
	        if(diff==0){
	            break;
	        }
	        if(a.get(i)==minimum)
	            i++;
	        else if(b.get(j)==minimum)
	            j++;
	        else k++;     
	    }
	   return diff; 
	}
	//implement approach with binary search
}
