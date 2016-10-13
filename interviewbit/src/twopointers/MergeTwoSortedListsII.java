package twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoSortedListsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr1=new Integer[]{1,3,4,6,10,12};
		ArrayList<Integer> a = new ArrayList(Arrays.asList(arr1));
		Integer[] arr2=new Integer[]{2,3,5,9};
		ArrayList<Integer> b = new ArrayList(Arrays.asList(arr2));
		merge(a,b);
		for(int i=0;i<a.size();i++){
			System.out.print(a.get(i)+" ");
		}
	}
	public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
	    int m=a.size();
	    int n=b.size();
	    ArrayList<Integer> temp=new ArrayList<>();
	    int i=0,j=0,k=0;
	    while(i<m && j<n){
	        if(a.get(i)<=b.get(j)){
	            temp.add(a.get(i));
	            i++;
	        }else{
	            temp.add(b.get(j));
	            j++;
	        }
	    }
	    while(i<m){
	        temp.add(a.get(i));
	        i++;
	    }
	    while(j<n){
	        temp.add(b.get(j));
	        j++;	
	    }
	    a.clear();
	    for(int l=0;l<temp.size();l++)
	    	a.add(temp.get(l));
	}
}
