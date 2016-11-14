package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a=Arrays.asList(0,8,4,12,2,10,6);
		System.out.println(lis(a));
	}
	public static int lis(final List<Integer> a) {
	    List<Integer> b=new ArrayList<>(a);
	    Collections.sort(b);
	    int[][] mem=new int[a.size()+1][a.size()+1];
	    for(int i=0;i<mem.length;i++){
	    	mem[i][0]=0;
	    	mem[0][i]=0;
	    }
	    int n=a.size();
	    for(int i=1;i<=n;i++){
	    	for(int j=1;j<=n;j++){
	    		if(a.get(i-1)==b.get(j-1)){
	    			mem[i][j]=mem[i-1][j-1]+1;
	    		}else{
	    			mem[i][j]=Math.max(mem[i-1][j], mem[i][j-1]);
	    		}
	    		System.out.print(mem[i][j]+" ");
	    	}
	    	System.out.println();
	    }
	    return mem[n][n];
	}
	
	public static int lis2(final List<Integer> a) {
	    if(a.size()==1)
	        return 1;
	    int n=a.size();
        int[] mem=new int[n];
        for(int i=0;i<n;i++)
            mem[i]=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(a.get(i)>a.get(j) && mem[i]<mem[j]+1)
                    mem[i]=mem[j]+1;
            }
        }
        int max=0;
        for(int i=0;i<n;i++)
            if(max<mem[i])
                max=mem[i];
        return max;
	}
}
