package graphs;

import java.util.ArrayList;

public class WordSearchBoard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words=new String[]{"FEDCBECD", "FABBGACG", "CDEDGAEC", "BFFEGGBA", "FCEEAFDA", "AGFADEAC", "ADGDCBAA", "EAABDDFF"};
		ArrayList<String> a=new ArrayList<>();
		for(String str:words)
			a.add(str);
		String b="BCDCB";
		System.out.println(exist(a, b));
	}
	
	public static int exist(ArrayList<String> a, String b) {
	    int m=a.size();
	    int n=a.get(0).length();
	    char[][] grid=new char[m][n];
	    for(int i=0;i<m;i++){
	        for(int j=0;j<n;j++){
	            grid[i][j]=a.get(i).charAt(j);
	        }
	    }
	    boolean result=false;
	    for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(dfs(grid,b,i,j,0)){
                    result = true;
                    break;
                }
            }
            if(result)
                break;
        }
        return result?1:0;
	    
	}
	
	public static boolean dfs(char[][] board, String word, int i, int j, int k){
        int m = board.length;
        int n = board[0].length;
     
        if(i<0 || j<0 || i>=m || j>=n){
            return false;
        }
     
        if(board[i][j] == word.charAt(k)){
            char temp = board[i][j];
            //board[i][j]='#';		//uncomment this if character traversed once is not to be traversed again
            if(k==word.length()-1){
                return true;
            }else if(dfs(board, word, i-1, j, k+1)
            ||dfs(board, word, i+1, j, k+1)
            ||dfs(board, word, i, j-1, k+1)
            ||dfs(board, word, i, j+1, k+1)){
                return true;
            }
            //board[i][j]=temp;		//uncomment this if character traversed once is not to be traversed again
        }
     
        return false;
    }

}
