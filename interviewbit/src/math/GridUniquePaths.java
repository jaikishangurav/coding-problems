package math;

public class GridUniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int uniquePaths(int a, int b) {
	    return returnPaths(0,0,a,b);
	}
	
	public int returnPaths(int x, int y, int a, int b){
	    if(x>=a||y>=b)
	        return 0;
	    if(x==a-1&&y==b-1)
	        return 1;
	    return returnPaths(x+1,y,a,b)+returnPaths(x,y+1,a,b);     
	}
	
	

}
