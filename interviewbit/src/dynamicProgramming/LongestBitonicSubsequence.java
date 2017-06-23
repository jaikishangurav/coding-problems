package dynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class LongestBitonicSubsequence {

	public static void main(String[] args) {
		Integer[] arr=new Integer[]{1, 3, 5 ,6 ,4, 8, 4, 3, 2, 1};
		List<Integer> list=Arrays.asList(arr);
		int ans=longestSubsequenceLength(list);
		System.out.println("Longest bitonic subsequence:"+ans);

	}
	
	 public static int longestSubsequenceLength(final List<Integer> A) {
	        if(A==null || A.size()==0)
	            return 0;
	        int n=A.size();
	        int[] lis=new int[n];
	        int[] lds=new int[n];
	        for(int i=0;i<n;i++){
	            lis[i]=1;
	            lds[i]=1;
	        }
	        for(int i=1;i<n;i++){
	            for(int j=0;j<i;j++){
	                if(A.get(i)>A.get(j) && lis[i]<lis[j]+1){
	                    lis[i]=lis[j]+1;
	                }
	            }
	        }
	        for(int i=0;i<n;i++){
	        	System.out.print(lis[i]+" ");
	        }
	        System.out.println();
	        
	        for(int i=1;i<n;i++){
	            for(int j=0;j<i;j++){
	                if(A.get(i)<A.get(j) && lds[i]<lds[j]+1){
	                	lds[i]=lds[j]+1;
	                }
	            }
	        }
	        
	        for(int i=0;i<n;i++){
	        	System.out.print(lds[i]+" ");
	        }
	        System.out.println();
	        for(int i=0;i<n;i++){
	            lds[i]=1;
	        }
	        for (int i = n-2; i >= 0; i--)
	            for (int j = n-1; j > i; j--)
	                if (A.get(i) > A.get(j) && lds[i] < lds[j] + 1)
	                    lds[i] = lds[j] + 1;
	        for(int i=0;i<n;i++){
	        	System.out.print(lds[i]+" ");
	        }
	        System.out.println();
	        int max = lis[0] + lds[0] - 1;
	        for (int i = 1; i < n; i++)
	            if (lis[i] + lds[i] - 1 > max)
	                max = lis[i] + lds[i] - 1;
	        return max;
	        
	    }

}
