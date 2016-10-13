/**
 * 
 */
package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Jaikishan
 *
 */
public class ThreeSumZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Integer[] arr=new Integer[]{1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3};
		 ArrayList<Integer> a = new ArrayList(Arrays.asList(arr));
		 ArrayList<ArrayList<Integer>> ans= threeSum(a);
		 for(ArrayList<Integer> x:ans){
			 System.out.print("[");
			 for(Integer in:x){
				 System.out.print(in+",");
			 }
			 System.out.print("]");
		 }
	}
	public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
	    int n=a.size();
	    Collections.sort(a);
	    ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
	    for(Integer x:a){
	    	System.out.print(x+" ");
	    }
	    System.out.println();
	    ArrayList<Integer> temp=null;
	    for(int i=0;i<n-2;i++){
	        int j=i+1;
	        int k=n-1;
	        while(j<k){
	            int tempsum=a.get(i).intValue()+a.get(j).intValue()+a.get(k).intValue();
	            if(tempsum==0){
	                temp=new ArrayList<>();
	                temp.add(a.get(i));
	                temp.add(a.get(j));
	                temp.add(a.get(k));
	                ans.add(temp);
	                j++;
	                k--;
	                while(j<k && a.get(k).intValue()==a.get(k+1).intValue()){
	                    k-=1;
	                    //System.out.println(a.get(i)+"k:"+a.get(k).intValue()+":"+a.get(k+1).intValue());
	                }
	                while(j<k && a.get(j).intValue()==a.get(j-1).intValue()){
	                    j+=1;
	                    //System.out.println(a.get(i)+"j:"+a.get(j).intValue()+":"+a.get(j-1).intValue());
	                }
	            }else if(tempsum>0){
	                k-=1;
	            }else{
	                j+=1;
	            }
	        }
	    }
	    return ans;
	}
}
