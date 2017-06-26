package dynamicProgramming;
/*Problem statement:https://www.interviewbit.com/problems/max-product-subarray/
 * 
 * */
import java.util.Arrays;
import java.util.List;

public class MaxProductSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr=new Integer[]{-2,1,-3,4,-1,2,1,-5,4};
		List<Integer> a=Arrays.asList(arr);
		int product=maxProduct(a);
		System.out.println("Max Product:"+product);
	}
	
	public static int maxProduct(final List<Integer> a) {
		int n=a.size();
	    if(n==0)
	        return 0;
	    if(n==1)
	        return a.get(0);
	    int dp[][]=new int[n][n];
	    for(int i=0;i<n;i++){
	        Arrays.fill(dp[i],1);
	    }
	    int result=1;
	    for(int l=2;l<n-1;l++){
	        for(int i=0;i<n-l+1;i++){
	            dp[i][i]=a.get(i);
	            for(int j=i+l-1;j<n;j++){
	                dp[i][j]=dp[i][j-1]*a.get(j);
	                result=Math.max(result,dp[i][j]);
	            }
	        }
	    }
	    return result;
	}
	
	public static int maxProduct2(final List<Integer> a) {
	    int n=a.size();
	    if(n==0)
	        return 0;
	    if(n==1)
	        return a.get(0);
	    int[] max=new int[n];
	    int[] min=new int[n];
	    max[0]=min[0]=a.get(0);
	    int result=a.get(0);
	    for(int i=1;i<n;i++){
	        if(a.get(i)>0){
	            max[i]=Math.max(a.get(i),max[i-1]*a.get(i));
	            min[i]=Math.min(a.get(i),min[i-1]*a.get(i));
	        }else{
	            max[i]=Math.max(a.get(i),min[i-1]*a.get(i));
	            min[i]=Math.min(a.get(i),max[i-1]*a.get(i));
	        }
	        result = Math.max(result, max[i]);
	    }
	    System.out.println("Max array");
	    display(max);
	    System.out.println("Min array");
	    display(min);
	    return result;
	}
	private static void display(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}

}
