package dynamicProgramming;
/*Problem statement:https://www.interviewbit.com/problems/rod-cutting/
 * Recurrence Relation:
 * DP(i, j)  = minimum cost for making cuts Ai,Ai+1,..,Aj.Note that you are not making cuts Ai and Aj, but they decide the cost for us.
 * For solving DP(i, j), we iterate k from i+1 to j-1, assuming that the first cut we make in this interval is Ak. 
 * The total cost required(if we make first cut at Ak) is (Aj - Ai) + DP(i, k) + DP(k, j).
 * DP(i,j) = (Aj-Ai) + Min{DP(i,k)+DP(k,j)} where k=i+1 to j-1 
 * 
 * This is our solution. We can implement this DP recursively with memoisation. Total complexity will be O(N^3).
 * For actually building the solution, after calculating dp(i, j), we can store the index k which gave the minimum cost and then we can build the solution backwards.
 * 
 * */
import java.util.ArrayList;
import java.util.Arrays;

public class RodCutting {

	public static void main(String[] args) {
		int A=5;	//rod length
		Integer[] cuts=new Integer[]{1, 2, 3, 4 };	//Integer representing weakpoints on rod where cuts are to be made
		ArrayList<Integer> B=new ArrayList<>();
		for(Integer in:cuts)
			B.add(in);
		ArrayList<Integer> result=rodCutDP1(A, new ArrayList<>(B));
		System.out.println("Order in which cuts to be made on rod to minimize cost:"+result);
		System.out.println("################################################################");
		result=rodCutDP2(A, new ArrayList<>(B));
		System.out.println("Order in which cuts to be made on rod to minimize cost:"+result);
	}
	
	//DP memoization without recursion
	public static ArrayList<Integer> rodCutDP1(int A, ArrayList<Integer> B) {
        B.add(0, 0);
        B.add(A);
        int size = B.size();
        long[][] cost = new long[size][size];
        int[][] index = new int[size][size];
        for (long[] arr : cost)
            Arrays.fill(arr, Long.MAX_VALUE);
        for (int i = 0; i < size - 1; i++) {
            cost[i][i + 1] = 0;
        }
    
        for (int length = 2; length <= size - 1; length++) {
            for (int i = 0; i < size - length; i++) {
                int j = i + length;
                long firstCut = ((long)B.get(j) - B.get(i));
                //cost[i][j] = cost[i][i + 1] + cost[i + 1][j] + firstCut;
                //index[i][j] = i + 1;
                for (int k = i + 1; k < j; k++) {
                    long new_cost = cost[i][k] + cost[k][j] + firstCut;
                    if (new_cost < cost[i][j]) {
                        cost[i][j] = new_cost;
                        index[i][j] = k;
                    }
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        display2(cost);
        //display(index);
        getSolution(0, size - 1, index, result, B);
        return result;
    }
	
	//DP memoization with recursion
	public static ArrayList<Integer> rodCutDP2(int A, ArrayList<Integer> B) {
        ArrayList<Integer> result=new ArrayList<>();
        ArrayList<Integer> cuts=new ArrayList<>();
        cuts.add(0);
        cuts.addAll(B);
        cuts.add(A);
        int size=cuts.size();
        long[][] cost = new long[size][size];
        int[][] index = new int[size][size];
        for (long[] arr : cost)
            Arrays.fill(arr, Long.MAX_VALUE);
        computeCost(0,size-1, cuts, cost,index);
        display2(cost);
        
        //display(index);
        getSolution(0, size - 1, index, result, cuts);
        return result;
        
    }
	
	private static long computeCost(int i, int j, ArrayList<Integer> cuts, long[][] cost, int[][] index){
		if(i>j-1)
			return 0;
		if(j-i==1){
			cost[i][j]=0;
			return 0;
		}
		if(cost[i][j]!=Long.MAX_VALUE)
			return cost[i][j];
		long firstCut= (long)cuts.get(j)-(long)cuts.get(i);
		//cost[i][j]=Long.MAX_VALUE/2;
		for(int k=i+1;k<j;k++){
			long newCost=firstCut+computeCost(i,k, cuts, cost,index)+computeCost(k,j, cuts, cost,index);
			if(newCost<cost[i][j]){
				cost[i][j]=newCost;
				index[i][j]=k;
			}				
		}
		return cost[i][j];
	}
	
	private static void getSolution(int i, int j,int[][] index, ArrayList<Integer> result, ArrayList<Integer> cuts){
		if (i >= j - 1) return;
	    int lowest = index[i][j];
	    result.add(cuts.get(lowest));
	    getSolution(i, lowest, index, result, cuts);
	    getSolution(lowest, j, index, result, cuts);
	}
	
	private static void display(int[][] index){
		for(int i=0;i<index.length;i++){
			for(int j=0;j<index[0].length;j++){
				System.out.print(index[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private static void display2(long[][] index){
		for(int i=0;i<index.length;i++){
			for(int j=0;j<index[0].length;j++){
				System.out.print(index[i][j]+" ");
			}
			System.out.println();
		}
	}

}
