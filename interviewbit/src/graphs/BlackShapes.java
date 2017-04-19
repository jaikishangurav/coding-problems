package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BlackShapes {

	int n;
	int m;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int black(ArrayList<String> a) {
        n=a.size();
        m=a.get(0).length();
        boolean[][] visited=new boolean[n][m];
        int shapes=0;
        for(int i=0;i<n;i++){
        	for(int j=0;j<m;j++){
        		if(a.get(i).charAt(j)=='X' && !visited[i][j]){
        			dfs(i,j,visited,a);
        			++shapes;
        		}
        	}
        }
        return shapes;
        
    }
	
	public void dfs(int row, int col,boolean visited[][],ArrayList<String> a){
		int[] rowNbr=new int[]{-1,0,0,1};
		int[] colNbr=new int[]{0,-1,1,0};
		visited[row][col]=true;
		for(int k=0;k<4;k++){
			if(isSafe(row+rowNbr[k],col+colNbr[k],visited,a)){
				dfs(row+rowNbr[k],col+colNbr[k],visited,a);
			}
		}		
	}
	
	public boolean isSafe(int row, int col, boolean visited[][], ArrayList<String> a){
		return (row>=0) &&(row<n)
				&& (col>=0 && col<m)
				&&(a.get(row).charAt(col)=='X' && !visited[row][col]); 
	}
}
class Cell{
	int x;
	int y;
	public Cell(int x,int y){
		this.x=x;
		this.y=y;
	}
}
