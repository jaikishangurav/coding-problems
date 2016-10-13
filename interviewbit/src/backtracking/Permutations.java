package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutations {

	public static void main(String[] args) {
		Integer[] arr=new Integer[]{1,2,3};
		ArrayList<Integer> a=new ArrayList<>(Arrays.asList(arr));
		ArrayList<ArrayList<Integer>> result= permute(a);
		System.out.println("*****Result****");
		for(ArrayList<Integer> ans:result){
			display(ans,0);
		}
	}
	public static ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
	    ArrayList<ArrayList<Integer>> result=new ArrayList<>();
	    if(a.size()==0){
	        return result;
	    }
	    if(a.size()==1){
	        result.add(new ArrayList<Integer>(a));
	        return result;
	    }
	    int n=a.size()-1;
        permutations(0,a,result);
        return result;
	}
	public static void permutations(int l,ArrayList<Integer> a, ArrayList<ArrayList<Integer>> res){
	    if(l>=a.size()){
	    	display(a,5);
	        res.add(new ArrayList<Integer>(a));
	    }else{
	        for(int i=l;i<=a.size()-1;i++){
	        	display(a,1);
	            swap(a,l,i);
	            display(a,2);
	            permutations(l+1,a,res);
	            display(a,3);
	            swap(a,l,i);
	            display(a,4);
	        }
	    }
	}
	public static void swap(ArrayList<Integer> a, int i, int j){
	    Integer temp=a.get(i);
	    a.set(i,a.get(j));
	    a.set(j,temp);
	}
	public static void display(ArrayList<Integer> temp,int i){
		System.out.println(i+":"+temp);
	}
}
