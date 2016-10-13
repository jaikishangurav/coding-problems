package backtracking;

import java.util.ArrayList;

public class Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> result=combine(4,3);
		System.out.println("*****Result****");
		for(ArrayList<Integer> arr:result){
			display(arr,0);
		}
	}
	public static ArrayList<ArrayList<Integer>> combine(int n, int k) {
	    ArrayList<ArrayList<Integer>> result=new ArrayList<>();
	    if(n<=0 || k>n){
	        return result;
	    }
	    ArrayList<Integer> temp=new ArrayList<>();
	    dfs(n,k,1,temp,result);
	    return result;
	    
	}
	public static void dfs(int n, int k, int start, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> result){
	    if(temp.size()==k){
	    	display(temp,3);
	        result.add(new ArrayList<Integer>(temp));
	        return;
	    }
	    for(int i=start;i<=n;i++){
	        temp.add(i);
	        dfs(n,k,i+1,temp,result);
	        display(temp,1);
	        temp.remove(temp.size()-1);
	        display(temp,2);
	    }
	}
	public static void display(ArrayList<Integer> temp,int i){
		System.out.println(i+":"+temp);
	}
}
