package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Subset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr=new Integer[]{12,13};
		ArrayList<Integer> a=new ArrayList<>(Arrays.asList(arr));
		ArrayList<ArrayList<Integer>> result= subsets(a);
		System.out.println("*****Result****");
		for(ArrayList<Integer> ans:result){
			display(ans,4);
		}
	}
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {
	    ArrayList<ArrayList<Integer>> result=new ArrayList<>();
	    if(a.size()==0){
	        return result;
	    }else{
	        ArrayList<Integer> temp=new ArrayList<>();
	        result.add(new ArrayList<Integer>(temp));
	        allSubsets(a,0,temp,result);
	        return result;
	        
	    }
	}
	public static void allSubsets(ArrayList<Integer> a, int start, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result){
		if(start==a.size()){
			return;
		}
	    for(int i=start;i<a.size();i++){
	        display(temp,0);
	        temp.add(a.get(i));
	        result.add(new ArrayList<Integer>(temp));
	        display(temp,1);
	        allSubsets(a,i+1,temp,result);
	        display(temp,2);
	        temp.remove(temp.size()-1);
	        display(temp,3);
	    } 
	}
	public static void display(ArrayList<Integer> temp,int i){
		System.out.println(i+":"+temp);
	}
}
