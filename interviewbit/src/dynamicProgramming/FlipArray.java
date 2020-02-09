package dynamicProgramming;
/*Problem statement:https://www.interviewbit.com/problems/flip-array/
 * This problem similar to 0/1 knapsack problem where we either choose a number and flip it or we don't. 
 * Similar to knapsack where we either choose an item and put it in sack or we don't.
 * If sum of all elements is S then using the knapsack approach we use a knapsack having max weight as S/2. So the problem is to fill Knapsack of 
 * size S/2 as fully as possible with minimum number of elements. Sign of elements that fall in knapsack wil be flipped.
 * As sum of all the elements in the Knapsack will be as close to S/2 as possible, 
 * we are indirectly calculating minimum non-negative sum of all the elements after flipping the sign.
 * Recurrence Relation:
 * If V is the highest total value that can be achieved from item types k through N, assuming that the knapsack has a remaining capacity of i.
 * let n be the minimum numbers that we have to negate and s=S/2 be the sum that we want to reach
 * V(n,s)=max{a[i]+V(i-1,j-a[i]),V(i-1,j)} <=s and n is minimum where 0<=i<=n and 0<=j<=s
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr=new Integer[]{14, 10, 4};
		List<Integer> a=Arrays.asList(arr);
		int minFlips=flipArrayRec(a);
		System.out.println("Minimum flips required using Recursion:"+minFlips);
		minFlips=flipArrayDP(a);
		System.out.println("Minimum flips required using DP:"+minFlips);
	}
	
	public static int flipArrayRec(final List<Integer> a){
		int n=a.size();
		int sum=0;
		for(Integer in:a)
            sum+=in;
        int w=sum/2;
        Node ans=new Node(0,0);
        ans=minFlips(a, n, w, ans);
        return ans.items;
	}
	
	private static Node minFlips(List<Integer> a, int n,int w,Node ans){
		if(n==0 || w==0)
			return new Node(0,0);
		if(a.get(n-1)>w)
			return minFlips(a,n-1,w,ans);
		else{
            Node temp=minFlips(a,n-1,w-a.get(n-1),ans);
            int curWeight=temp.weight+a.get(n-1);
            int curItem=temp.items+1;            
            if(curWeight>ans.weight || curWeight==ans.weight && curItem<ans.items)
            	return new Node(curWeight,curItem);
            else return minFlips(a,n-1,w,temp);
		}
	}
	
	//Dynamic Programming approach
	public static int flipArrayDP(final List<Integer> a) {
        int n=a.size();
        int sum=0;
        for(Integer in:a)
            sum+=in;
        int w=sum/2;
        Node[][] dp=new Node[n+1][w+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=w;j++){
                if(i==0 || j==0)
                    dp[i][j]=new Node(0,0);
                else{
                    int prevItem=dp[i-1][j].items;
                    int prevWeight=dp[i-1][j].weight;
                    if(j-a.get(i-1)>=0){
                        int curWeight=dp[i-1][j-a.get(i-1)].weight+a.get(i-1);
                        int curItem=dp[i-1][j-a.get(i-1)].items+1;
                        if(curWeight>prevWeight || curWeight==prevWeight && curItem<prevItem){
                            dp[i][j]=new Node(curWeight,curItem);
                        }else{
                            dp[i][j]=dp[i-1][j];
                        }
                    }else{
                        dp[i][j]=dp[i-1][j];
                    }
                }
            }
        }
        return dp[n][w].items;
    }

}

class Node{
    int weight;
    int items;
    public Node(int weight, int item){
        this.weight=weight;
        this.items=item;
    }
}
