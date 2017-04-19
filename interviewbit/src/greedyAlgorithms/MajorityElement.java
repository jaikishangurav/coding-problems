package greedyAlgorithms;

import java.util.Arrays;
import java.util.List;

public class MajorityElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] numbers=new Integer[]{1,2,2,6,2,2,5,2,2,7};
		List<Integer> list=Arrays.asList(numbers);
		System.out.println("Majority element:"+majorityElement(list));
	}
	public static int majorityElement(final List<Integer> a) {
	    int count=1;
	    int current=a.get(0);
	    int n=a.size();
	    for(int i=1;i<n;i++){
	        if(a.get(i)==current){
	            count++;
	        }else{
	            if(count==1){
	                current=a.get(i);
	            }else{
	                count--;
	            }
	        }
	    }
	    count=0;
	    for(int i=0;i<n;i++){
	    	if(a.get(i)==current)
	    		count++;
	    }
	    return count>n/2?current:Integer.MIN_VALUE;
	}

}
