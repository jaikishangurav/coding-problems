package twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class Diffk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr1=new Integer[]{1,3,4,6,10,13};
		ArrayList<Integer> a = new ArrayList(Arrays.asList(arr1));
		System.out.println(diffPossible(a, 6));
	}
	public static int diffPossible(ArrayList<Integer> a, int b) {
		int ans=0;
	    int n=a.size();
	    int j=1;
	    for(int i=0;i<n;i++){
	        for(;j<n;j++){
	            if(a.get(j).intValue()-a.get(i).intValue()==b){
	                return 1;
	            }
	            if(a.get(j).intValue()-a.get(i).intValue()>b){
	                break;
	            }
	        }
	    }
	    return ans;
	}
}
