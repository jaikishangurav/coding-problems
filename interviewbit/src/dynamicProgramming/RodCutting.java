package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class RodCutting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<Integer> rodCut(int A, ArrayList<Integer> B) {
        ArrayList<Integer> result=new ArrayList<>();
        ArrayList<Integer> cuts=new ArrayList<>();
        cuts.add(0);
        cuts.addAll(B);
        cuts.add(A);
        int size=cuts.size();
        long[][] cost = new long[size][size];
        int[][] index = new int[size][size];
        for (long[] arr : cost)
            Arrays.fill(arr, -1);
        computeCost(0,size-1, cuts, cost,index);
        getSolution(0, size - 1, index, result, cuts);
        return result;
        
    }
	
	private long computeCost(int i, int j, ArrayList<Integer> cuts, long[][] cost, int[][] index){
		if(i>j-1)
			return 0l;
		if(cost[i][j]!=-1)
			return cost[i][j];
		long firstCut= cuts.get(j)-cuts.get(i);
		cost[i][j]=Long.MAX_VALUE/2;
		for(int k=i+1;k<j;k++){
			long newCost=firstCut+computeCost(i,k, cuts, cost,index)+computeCost(k,j, cuts, cost,index);
			if(newCost<cost[i][j]){
				cost[i][j]=newCost;
				index[i][j]=k;
			}				
		}
		return cost[i][j];
	}
	
	private void getSolution(int i, int j,int[][] index, ArrayList<Integer> result, ArrayList<Integer> cuts){
		if (i >= j - 1) return;
	    int lowest = index[i][j];
	    result.add(cuts.get(lowest));
	    getSolution(i, lowest, index, result, cuts);
	    getSolution(lowest, j, index, result, cuts);
	}

}
