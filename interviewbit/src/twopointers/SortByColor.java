package twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class SortByColor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr1=new Integer[]{1,0,2,0,1,0,2,2,0,0,2,1,0,2,1,0,2,1,1,1,2,0,0,1};
		ArrayList<Integer> a = new ArrayList(Arrays.asList(arr1));
		sortColors2(a);
		for(Integer i:a)
			System.out.print(i+" ");
	}
	//Counting sort
	public void sortColors(ArrayList<Integer> a) {
	    int[] countArray=new int[3];
	    for(int i=0;i<a.size();i++){
	        countArray[a.get(i)]++;
	    }
	    int j=0;
	    int k=0;
	    while(j<=2){
	        if(countArray[j]!=0){
	            a.set(k,j);
	            countArray[j]-=1;
	            k++;
	        }else{
	            j++;
	        }
	    }
	    
	}
	
	//Put all zeros in front and twos at back, ones will allign automatically
		public static void sortColors2(ArrayList<Integer> a) {
		    int i=0;
		    int j=a.size()-1;
		    int k=0;
		    while(k<=j){
		    	if(a.get(k)==0){
		    		int temp=a.get(i);
					a.set(i, 0);
					a.set(k, temp);
		    		i++;
		    		k++;
		    	}
		    	else if(a.get(k)==2){
		    		int temp=a.get(j);
					a.set(j, 2);
					a.set(k, temp);
		    		j--;
		    	}else{
		    	k++;
		    	}
		    }
		    
		}
		
		public static void swap(ArrayList<Integer> a,int i,int j){
			int temp=a.get(i);
			a.set(i, a.get(j));
			a.set(j, temp);
		}
		public static void sortColors3(ArrayList<Integer> A) {
			int zero = 0;
		    int two = A.size() - 1;
		    
		    for (int i = 0; i <= two;) {
		        if (A.get(i) == 0) {
		            int temp = A.get(zero);
		            A.set(zero, 0);
		            A.set(i, temp);
		            zero++;
		            i++;
		        } else if (A.get(i) == 2) {
		            int temp = A.get(two);
		            A.set(two, 2);
		            A.set(i, temp);
		            two--;
		        } else {
		            i++;
		        }
		    }
		}
}
