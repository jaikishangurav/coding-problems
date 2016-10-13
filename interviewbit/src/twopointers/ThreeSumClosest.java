package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Integer[] arr=new Integer[]{2, 1, -9, -7, -8, 2, -8, 2, 3, -8 };
		 ArrayList<Integer> a = new ArrayList(Arrays.asList(arr));
		 int ans=threeSumClosest(a,-1);
		 System.out.println(ans);
	}
	public static int threeSumClosest(ArrayList<Integer> a, int b) {
	    int n=a.size();
	    Collections.sort(a);
	    int tempsum=0;
	    long ans=Integer.MAX_VALUE;
	    for(int i=0;i<n-2;i++){
	        if(i==0||a.get(i)>a.get(i-1)){
	        int j=i+1;
	        int k=n-1;
	        while(j<k){
	            tempsum=a.get(i)+a.get(j)+a.get(k);
	            if(tempsum==b){
	                return b;
	            }else if(tempsum>b){
	                k--;
	            }else{
	                j++;
	            }
	            if(Math.abs(ans-b)>Math.abs(tempsum-b)){
	                ans=tempsum;
	            }
	            System.out.println("ans:"+ans+"||tempsum:"+tempsum);
	        }
	        }
	    }
	    return (int)ans;
	}
}
