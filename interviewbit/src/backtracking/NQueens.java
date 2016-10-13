package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class NQueens {
	public static final String newline = System.getProperty("line.separator");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sr=new Scanner(System.in);
		int a=sr.nextInt();
		ArrayList<ArrayList<String>> result=new ArrayList<>();
		result=solveNQueens(a);
		for(ArrayList<String> arr:result){
			System.out.println("[");
			for(String ans:arr){
				System.out.print(ans);
				System.out.print(","+newline);
			}
			System.out.println("],");
		}
	}
	public static ArrayList<ArrayList<String>> solveNQueens(int a) {
	    ArrayList<ArrayList<String>> result=new ArrayList<>();
	    if(a==1){
	        String ans="Q";
	        ArrayList<String> temp=new ArrayList<>();
	        temp.add(ans);
	        result.add(temp);
	        return result;
	    }
	    if(a==0||a==2||a==3){
	    	return result;
	    }
	    int[] brd=new int[a];
	    placeQueen(brd,0,a,result);
	    return result;
	}
	public static void placeQueen(int[] brd,int row,int a, ArrayList<ArrayList<String>> result){
	    if(row==a){
	    	System.out.println("Solution added");
	        addSolution(brd,a,result);
	        return; 
	    }
	    for(int i=0;i<a;i++){
	        if(isSafe(brd,row,i,a)){
	            brd[row]=i;
	            placeQueen(brd,row+1,a,result);	  
	        }
	    }
	}
	public static boolean isSafe(int[] brd, int row, int col, int a){
	    int i;
	    for(i=0;i<row;i++){
	        if(brd[i]==col || (row-i)==(Math.abs(col-brd[i]))){
	            return false;
	        }
	    }
	    return true;
	}
	public static void addSolution(int[] brd,int a, ArrayList<ArrayList<String>> result){
		System.out.println("AddSolution");
	    ArrayList<String> temp=new ArrayList<>();
	    for(int i=0;i<brd.length;i++){
	    	StringBuilder sb= new StringBuilder();
	    	for(int j=0;j<brd.length;j++){
	    		if(brd[i]==j){
	    			sb.append("Q");
	    		}else{
	    			sb.append(".");
	    		}
	    	}
	    	temp.add(sb.toString());
	    }
	    result.add(new ArrayList<>(temp));
	}
	public static void display(int[] brd,int row){
		System.out.print("row:"+row+"[");
		for(int i=0;i<brd.length;i++){
			System.out.print(brd[i]);
			if(i!=brd.length-1)
				System.out.print(", ");
		}
		System.out.print("]"+newline);
	}

}
