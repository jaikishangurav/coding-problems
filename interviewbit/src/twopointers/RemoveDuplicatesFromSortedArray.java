package twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr=new Integer[]{0,0,0,0,1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,3};
		ArrayList<Integer> a = new ArrayList(Arrays.asList(arr));
		int n=removeDuplicatesNaive(a);
		//int[] ar1=new int[]{0,0,0,0,1,1,1,1,1,2,2,2,2,2,3,3,3,3,3,3};
		//int n1=removeDuplicatesNaive(ar1);
		System.out.println("new size:"+n);
		for(int i=0;i<n;i++)
			System.out.print(a.get(i)+" ");
		System.out.println();
		//System.out.println("new size n1:"+n1);
		//for(int i=0;i<n1;i++)
		//	System.out.print(ar1[i]+" ");
	}
	public static int removeDuplicates(ArrayList<Integer> a) {
	    int j=1;
	    int i=0;
	    while(j<a.size()){
	       //System.out.println(a.get(i).intValue()+"=="+a.get(j).intValue());
	       if(a.get(i).equals(a.get(j))){
	           j++;
	       }else{
	    	   i+=1;
	           a.set(i, a.get(j));
	           j=j+1;
	       }
	   }
	   return i+1;
	}
	
	public static int removeDuplicatesNaive(ArrayList<Integer> A) {
		int index = 1;
	    int n = A.size();
	    
	    if (A == null || A.size() == 0)
	        return 0;
	    
	    for (int i = 1; i < n; i++) {
	        
	        if (A.get(i).intValue() != A.get(i - 1).intValue()) {
	            int temp = A.get(index);
	            A.set(index, A.get(i));
	            index++;
	        }
	    }
	    
	    return index;
	    
	}
}
