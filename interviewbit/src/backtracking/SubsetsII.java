package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SubsetsII {

	public static void main(String[] args) {
		Integer[] arr=new Integer[]{1,2,2};
		ArrayList<Integer> a=new ArrayList<>(Arrays.asList(arr));
		ArrayList<ArrayList<Integer>> result= subsetsWithDup(a);
		System.out.println("*****Result****");
		for(ArrayList<Integer> ans:result){
			display(ans,4);
		}

	}
	public static ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> result=new ArrayList<>();
	    if(a.size()==0){
	        result.add(new ArrayList<Integer>());
	        return result;
	    }else{
	        Collections.sort(a);
	        Set<ArrayList<Integer>> tempRes=new LinkedHashSet<>();
	        ArrayList<Integer> temp=new ArrayList<>();
	        tempRes.add(new ArrayList<Integer>(temp));
	        allSubsets(a,0,temp,tempRes);
	        for(ArrayList<Integer> arin:tempRes){
	        	result.add(arin);
	        }
	        return result;
	        
	    }
	    
	}
	
	public static void allSubsets(ArrayList<Integer> a, int start, ArrayList<Integer> temp, Set<ArrayList<Integer>> tempRes){
		if(start==a.size()){
			return;
		}
	    for(int i=start;i<a.size();i++){
	        temp.add(a.get(i));
	        tempRes.add(new ArrayList<Integer>(temp));
	        allSubsets(a,i+1,temp,tempRes);
	        temp.remove(temp.size()-1);
	    } 
	}
	public static void display(ArrayList<Integer> temp,int i){
		System.out.println(i+":"+temp);
	}
}

