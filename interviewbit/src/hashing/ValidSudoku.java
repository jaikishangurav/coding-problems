package hashing;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr={"..5.....6", "....14...", ".........", ".....92..", "5....2...", ".......3.", "...54....", "3.....42.", "...27.6.."};
		List<String> sudoku=Arrays.asList(arr);
		int ans=isValidSudoku(sudoku);
		System.out.println(ans);
	}

	public static int isValidSudoku(final List<String> a) {
	    Set<Character> rows;
	    Set<Character> cols;
	    
	    //check rows and column
	    for(int i=0;i<9;i++){
	        rows=new HashSet<>();
	        cols=new HashSet<>();
	        for(int j=0;j<9;j++){
	            if(a.get(i).charAt(j)!='.' && !rows.add(a.get(i).charAt(j))){
	            	System.out.println(i+","+j);
	                return 0;
	            }
	            if(a.get(j).charAt(i)!='.' && !cols.add(a.get(j).charAt(i))){
	            	System.out.println(j+","+i);
	                return 0;
	            }
	        }
	    }
	    
	    int block=0;
	    for(int i=0;i<9;i+=3){
	        for(int j=0;j<9;j+=3){
	            rows=new HashSet<>();
	            for(int k=i;k<i+3;k++){
	                for(int l=j;l<j+3;l++){
	                    if(a.get(k).charAt(l)!='.' && !rows.add(a.get(k).charAt(l))){
	                        return 0;
	                    }
	                }
	            }
	        }
	    }
	    
	    return 1;
	}
	
}
