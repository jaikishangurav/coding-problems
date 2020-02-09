package hashing;
/* Problem Statement:https://www.interviewbit.com/courses/programming/topics/hashing/problems/2-sum/
 * */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr={4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
		List<Integer> a=Arrays.asList(arr);
		int b=-3;
		ArrayList<Integer> result=twoSum(a, b);
		System.out.println(result);
				
	}
	
	//Brute Force Approach Time Complexity:O(n^2) and Space Complexity:O(1)
	public ArrayList<Integer> twoSumBF(final List<Integer> a, int b) {
	    ArrayList<Integer> result=new ArrayList<>();
	    int index1=0;
	    int index2=0;
	    for(int i=1;i<a.size();i++){
	        index2=i;
	        for(int j=0;j<i;j++){
	            if(a.get(i)+a.get(j)==b){
	                index1=j;
	                result.add(index1+1);
	                result.add(index2+1);
	                return result;
	            }
	        }
	    }
	    return result;
	}

	//Using hashing technique Time Complexity:O(n) and Space Complexity:O(n)
	public static ArrayList<Integer> twoSum(final List<Integer> a, int b) {
	    ArrayList<Integer> result=new ArrayList<>();
	    Map<Integer,Integer> map=new HashMap<>();
	    for(int i=0;i<a.size();i++){
	        int req=b-a.get(i);
	        if(map.containsKey(req)){
	            result.add(map.get(req)+1);
	            result.add(i+1);
	            return result;
	        }
	        if(!map.containsKey(a.get(i)))
	            map.put(a.get(i),i);
	    }
	    return result;
	}
}
