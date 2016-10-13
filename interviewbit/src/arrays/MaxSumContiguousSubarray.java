package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxSumContiguousSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr = new Scanner(System.in);
		List<Integer> a = new ArrayList<>();
		int n = sr.nextInt();
		for(int i=0;i<n;i++)
			a.add(sr.nextInt());
		System.out.println(maxSubArray(a));
	}
	public static int maxSubArray(final List<Integer> a) {
	    if(a.size()==1)
	        return a.get(0);
	    int lo=0;
	    int hi=a.size();
	    int maxsum=Integer.MIN_VALUE;
	    int cursum=0;
	    for(int i=lo;i<hi;i++){
	        cursum=0;
	        for(int j=i;j<hi;j++){
	            cursum+=a.get(j);
	            if(maxsum<cursum){
	                maxsum=cursum;
	            }
	        }
	    }
	    return maxsum;
	}
}
