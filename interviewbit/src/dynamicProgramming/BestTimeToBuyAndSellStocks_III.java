package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTimeToBuyAndSellStocks_III {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] priceArray=new Integer[]{1, 4, 5, 7, 6, 3, 2, 9};
		System.out.println("1, 4, 5, 7, 6, 3, 2, 9");
		final List<Integer> prices=Arrays.asList(priceArray);
		int profit=maxProfit_2(prices);
		System.out.println("Max profit:"+profit);
	}
	
	// Time O(n) and Space O(n) approach
	public static int maxProfit(final List<Integer> a) {
	    if(a==null||a.size()==0||a.size()==1)
	        return 0;
	    int n=a.size();
	    int[] left=new int[n];
	    int[] right=new int[n];
	    int min=a.get(0);
	    left[0]=0;
	    for(int i=1;i<n;i++){
	        min=Math.min(min,a.get(i));
	        left[i]=Math.max(left[i-1],a.get(i)-min);
	    }
	    
	    right[n-1]=0;
	    int max=a.get(n-1);
	    for(int i=n-2;i>=0;i--){
	        max=Math.max(max,a.get(i));
	        right[i]=Math.max(right[i+1],max-a.get(i));
	    }
	    int profit=0;
	    for(int i=0;i<n;i++){
	        profit=Math.max(profit,left[i]+right[i]);
	    }
	    return profit;
	}
	
	// Time O(n) and Space O(1) approach
	public static int maxProfit_2(final List<Integer> a) {
	    int n=a.size();
	    if(n<2)
	        return 0;
	    int[] buy=new int[2];
	    buy[0]=buy[1]=Integer.MIN_VALUE;
	    int[] sell=new int[2];
	    sell[0]=sell[1]=0;
	    for(int i=0;i<n;++i){
	    	System.out.println("For stock on day "+i+" and price "+a.get(i));
	    	System.out.println("sell[1]:"+sell[1]+" buy[1]:"+buy[1]+" sell[0]:"+sell[0]+" buy[0]:"+buy[0]);
	        sell[1] = Math.max(sell[1], buy[1] + a.get(i));
            buy[1] = Math.max(buy[1], sell[0] - a.get(i));
            sell[0] = Math.max(sell[0], buy[0] + a.get(i));
            buy[0] = Math.max(buy[0], 0 - a.get(i));
            System.out.println("sell[1]:"+sell[1]+" buy[1]:"+buy[1]+" sell[0]:"+sell[0]+" buy[0]:"+buy[0]);
            System.out.println();
	    }
	    return sell[1];
	}

}
