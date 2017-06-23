package arrays;

import java.util.Arrays;
import java.util.List;

public class MaximumConsecutiveGap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] nums=new Integer[]{16,56,35,49,23,68};
		List<Integer> list=Arrays.asList(nums);
		int result=maximumGap(list);
		System.out.println(result);
	}

	public static int maximumGap(final List<Integer> a) {
	    if(a.size()<2)
	        return 0;
	    int max=Integer.MIN_VALUE;
	    int min=Integer.MAX_VALUE;
	    for(Integer i:a){
	        max=Math.max(max,i);
	        min=Math.min(min,i);
	    }
	    int n=a.size();
	    Bucket[] buckets=new Bucket[n-1];
	     for(int i=0; i<buckets.length; i++){
            buckets[i] = new Bucket();
	     }
         int gap=(max-min-1)/(n-1)+1;
         System.out.println("interval:"+gap);
         for(int i=0;i<a.size();i++){
             int index=(int)((a.get(i)-min)/gap);
             System.out.println(index+":"+a.get(i));
              if(buckets[index].low == -1){
                buckets[index].low = a.get(i);
                buckets[index].high = a.get(i);
            }else{
                buckets[index].low = Math.min(buckets[index].low, a.get(i));
                buckets[index].high = Math.max(buckets[index].high, a.get(i));
            }
         }
         //scan buckets to find maximum gap
        for(int j=0;j<buckets.length;j++){
        	System.out.println(j+":"+buckets[j]);
        }
        int result = 0;
        int prev = buckets[0].high;
        for(int i=1; i<buckets.length; i++){
            if(buckets[i].low != -1){
                result = Math.max(result, buckets[i].low-prev);
                prev = buckets[i].high;
            }
     
        }
     
        return result;
    }
	
	private static class Bucket{
	    int low;
	    int high;
	    @Override
		public String toString() {
			return "Bucket [low=" + low + ", high=" + high + "]";
		}
		public Bucket(){
	        low = -1;
	        high = -1; 
	    }
	}
}
