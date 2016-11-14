package dynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class BestTimeToBuyAndSellStocks_I {
	static int maxProfit=0;
	static int min;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final List<Integer> a= Arrays.asList(1,2,1,4,3,6,7);
		System.out.println("Max Profit:"+maxProfit(a));
	}
	public static int maxProfit(final List<Integer> a) {
	    if(a.size()==0)
	        return 0;
	    maxProfit=0;
	    min=a.get(0);
	    a.forEach(price->{
	    	maxProfit=Math.max(maxProfit, price-min);
	    	min=Math.min(min, price);	    	
	    });
	    return maxProfit;
	}

}
