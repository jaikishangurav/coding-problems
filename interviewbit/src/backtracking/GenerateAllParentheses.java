package backtracking;

import java.util.ArrayList;

public class GenerateAllParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> result = generateParenthesis(3);
		System.out.println("*****Result****");
		System.out.println(result);
	}
	public static ArrayList<String> generateParenthesis(int a) {
	    ArrayList<String> result=new ArrayList<String>();
	    if(a==0){
	        return result;
	    }
	    dfs(result,"",a,a);
	    return result;
	}
	public static void dfs(ArrayList<String> result, String s, int left, int right){
	    if(left>right){
	        return;
	    }
	    if(left==0 && right==0){
	        result.add(s);
	        display(s,0);
	        return;
	    }
	    if(left>0){
	    	display(s,1);
	        dfs(result,s+"(",left-1,right);
	        display(s,2);
	    }
	    if(right>0){
	    	display(s,3);
	        dfs(result,s+")",left,right-1);
	        display(s,4);
	    }
	}
	public static void display(String temp,int i){
		System.out.println(i+":"+temp);
	}
}
