package dynamicProgramming;
/*Problem statement:https://www.interviewbit.com/problems/dungeon-princess/
 * Recurrence Relation:
(1) dp[i][j]>=1, since dp[i][j] can not be 0 or below anytime, even before entering any block.
(2) dp[i][j]+dungeon[i][j]>=1, since the knight's health should be at least 1 after entering the block[i][j].
(3) dp[i][j]+dungeon[i][j]>=dp[i+1][j], since the knight's health should be enough to start from the block under [i][j]
(4) dp[i][j]+dungeon[i][j]>=dp[i][j+1], since the knight's health should be enough to start from the next block on the right of [i][j].

In any case, equation (1) and equation (2) are required to be fulfilled. However, either (3) or (4) works, the knight can succeed. By moving the items on the left of equations (1) - (4) except dp[i][j] to the right, we have

(5) dp[i][j]>=1 
(6) dp[i][j]>=1- dungeon[i][j]
(7) dp[i][j]>= dp[i+1][j]-dungeon[i][j] OR dp[i][j+1]-dungeon[i][j].

Since we need to minimize the health needed, we take the minimum of the two routes in the equation (7). Then we have the final equation:
(8) dp[i][j]= maxOfThree(1, 1- dungeon[i][j], Math.min(dp[i+1][j]-dungeon[i][j], dp[i][j+1]-dungeon[i][j])).
 * */
import java.util.ArrayList;

public class DungeonPrincess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int calculateMinimumHP(ArrayList<ArrayList<Integer>> a) {
	    int m=a.size();
	    int n=a.get(0).size();
	    int[][] dp=new int[m][n];
	    for(int i=m-1;i>=0;i--){
	        for(int j=n-1;j>=0;j--){
	            if(i==m-1 && j==n-1){	//bottom right cell
	                dp[i][j]=Math.max(1-a.get(i).get(j),1);
	            }else if(i==m-1){   //last row
	                dp[i][j]=Math.max(dp[i][j+1]-a.get(i).get(j),1);
	            }else if(j==n-1){   //last column
	                dp[i][j]=Math.max(dp[i+1][j]-a.get(i).get(j),1);
	            }else{
	                int right=Math.max(dp[i][j+1]-a.get(i).get(j),1);
	                int down=Math.max(dp[i+1][j]-a.get(i).get(j),1);
	                dp[i][j]=Math.min(right,down);
	            }
	        }
	    }
	    return dp[0][0];
	}

}
