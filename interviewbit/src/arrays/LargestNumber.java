package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = new Integer[] {3, 30, 34, 5, 9};
		List<Integer> a = new ArrayList(Arrays.asList(arr));
		System.out.println(largestNumber(a));

	}
	
	public static String largestNumber(final List<Integer> a) {
		StringBuffer num=new StringBuffer();;
	    Integer[] arr = new Integer[a.size()];
	    for(int i=0;i<a.size();i++)
	    	arr[i]=(Integer)a.get(i);
	    Arrays.sort(arr, new Comparator<Integer>(){

			@Override
			public int compare(Integer a, Integer b) {
				// TODO Auto-generated method stub
				String x = String.valueOf(a);
				String y = String.valueOf(b);
				String xy=x+y;
				String yx=y+x;
				return xy.compareTo(yx)>0?-1:1;
			}
	    	
	    });
	    for(int i=0;i<arr.length;i++){
	        num.append(arr[i]);
	    }
	    String ans=num.toString();
	    ans = ans.replaceFirst ("^0*", "");
	    if (ans.isEmpty()) 
	    	ans = "0";
	    return ans;
	}

}
